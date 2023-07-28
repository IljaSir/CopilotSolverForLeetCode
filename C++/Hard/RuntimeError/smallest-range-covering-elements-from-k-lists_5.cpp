class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        
        vector<int> res;
        int k = nums.size();
        int n = nums[0].size();
        vector<int> idx(k, 0);
        int minVal = INT_MAX;
        int maxVal = INT_MIN;
        for (int i = 0; i < k; i++) {
            maxVal = max(maxVal, nums[i][0]);
        }
        while (true) {
            int minIdx = -1;
            minVal = INT_MAX;
            for (int i = 0; i < k; i++) {
                if (idx[i] < n && nums[i][idx[i]] < minVal) {
                    minVal = nums[i][idx[i]];
                    minIdx = i;
                }
            }
            if (maxVal - minVal < res.empty() ? INT_MAX : res[1] - res[0]) {
                res = {minVal, maxVal};
            }
            if (idx[minIdx] == n - 1) {
                break;
            }
            idx[minIdx]++;
            maxVal = max(maxVal, nums[minIdx][idx[minIdx]]);
        }
        return res;
    }
};