class Solution {
public:
    int maximumSum(vector<int>& nums) {
        
        int n = nums.size();
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sumOfDigits(nums[i]) == sumOfDigits(nums[j])) {
                    res = max(res, nums[i] + nums[j]);
                }
            }
        }
        return res;
    }
};