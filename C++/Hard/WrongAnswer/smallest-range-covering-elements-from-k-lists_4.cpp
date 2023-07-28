class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        
        int k = nums.size();
        vector<int> res;
        vector<int> index(k, 0);
        int minVal = INT_MAX;
        int maxVal = INT_MIN;
        for (int i = 0; i < k; ++i) {
            minVal = min(minVal, nums[i][0]);
            maxVal = max(maxVal, nums[i][0]);
        }
        res = {minVal, maxVal};
        while (true) {
            int minIndex = -1;
            minVal = INT_MAX;
            for (int i = 0; i < k; ++i) {
                if (index[i] < nums[i].size() && nums[i][index[i]] < minVal) {
                    minVal = nums[i][index[i]];
                    minIndex = i;
                }
            }
            if (minIndex == -1) {
                break;
            }
            ++index[minIndex];
            maxVal = max(maxVal, minVal);
            if (maxVal - minVal < res[1] - res[0]) {
                res = {minVal, maxVal};
            }
        }
        return res;
    }
};