class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int l = 0, r = n - 1;
        long long ans = 1;
        while (k > 0) {
            if (k == 1) {
                ans = (ans * nums[r]) % 1000000007;
                k--;
            } else {
                long long a = 1LL * nums[l] * nums[l + 1];
                long long b = 1LL * nums[r] * nums[r - 1];
                if (a > b) {
                    ans = (ans * a) % 1000000007;
                    l += 2;
                    k -= 2;
                } else {
                    ans = (ans * b) % 1000000007;
                    r -= 2;
                    k -= 2;
                }
            }
        }
        return ans;
    }
};