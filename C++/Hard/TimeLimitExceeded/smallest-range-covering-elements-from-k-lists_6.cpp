class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        
        int k = nums.size();
        vector<int> idx(k, 0);
        vector<int> ret(2, 0);
        int minVal = INT_MAX, maxVal = INT_MIN;
        for (int i = 0; i < k; i++) {
            maxVal = max(maxVal, nums[i][0]);
        }
        int range = INT_MAX;
        while (true) {
            int minIdx = -1;
            minVal = INT_MAX;
            for (int i = 0; i < k; i++) {
                if (idx[i] < nums[i].size() && nums[i][idx[i]] < minVal) {
                    minVal = nums[i][idx[i]];
                    minIdx = i;
                }
            }
            if (minVal > maxVal) {
                break;
            }
            if (maxVal - minVal < range) {
                range = maxVal - minVal;
                ret[0] = minVal;
                ret[1] = maxVal;
            }
            idx[minIdx]++;
            if (idx[minIdx] == nums[minIdx].size()) {
                break;
            }
            maxVal = max(maxVal, nums[minIdx][idx[minIdx]]);
        }
        return ret;
    }
};