class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        
        int n = nums.size();
        int i = 0, j = 0, ans = 0;
        long long prod = 1;
        while (j < n) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
};