class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        
        int n = nums.size(), res = -1;
        vector<int> minLeft(n);
        minLeft[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            minLeft[i] = min(minLeft[i - 1], nums[i]);
        }
        for (int i = 1; i < n; ++i) {
            if (nums[i] > minLeft[i - 1]) {
                res = max(res, nums[i] - minLeft[i - 1]);
            }
        }
        return res;
    }
};