class Solution {
public:
    bool findSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int sum1 = 0, sum2 = 0;
                for (int k = 0; k <= i; ++k) {
                    sum1 += nums[k];
                }
                for (int k = i + 1; k <= j; ++k) {
                    sum2 += nums[k];
                }
                if (sum1 == sum2) {
                    return true;
                }
            }
        }
        return false;
    }
};