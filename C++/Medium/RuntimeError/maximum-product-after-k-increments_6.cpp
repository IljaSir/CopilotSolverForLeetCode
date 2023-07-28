class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        
        int n = nums.size();
        int res = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            long long a = 1, b = 1;
            for (int t = 0; t < i; t++) {
                a *= nums[t];
            }
            for (int t = 0; t < j; t++) {
                b *= nums[n - 1 - t];
            }
            res = max(res, (int)(a * b % 1000000007));
        }
        return res;
    }
};