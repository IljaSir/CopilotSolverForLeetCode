class Solution {
public:
    int subarrayLCM(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> dp(k+1, 0);
        dp[0] = 1;
        int ans = 0;
        int cur = 1;
        for (int i = 0; i < n; ++i) {
            cur = cur * nums[i] / gcd(cur, nums[i]);
            if (cur > k) cur %= k;
            ans += dp[cur];
            dp[cur]++;
        }
        return ans;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] % k == 0) {
                ans += subarrayLCM(nums, k);
            }
        }
        return ans;
    }
    int gcd(int a, int b) {
        if (a < b) swap(a, b);
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }
};