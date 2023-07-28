class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int min_product = 1;
        for (int i = 0; i < k; ++i) {
            min_product *= nums[i];
        }
        int max_product = 1;
        for (int i = n - 1; i >= n - k; --i) {
            max_product *= nums[i];
        }
        if (k % 2 == 0) {
            return max_product % 1000000007;
        }
        int max_product1 = max_product / nums[n - k] * nums[k - 1];
        int max_product2 = max_product / nums[n - 1] * nums[0];
        return max(max_product1, max_product2) % 1000000007;
    }
};