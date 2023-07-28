class Solution {
public:
    int squareFreeSubsets(vector<int>& nums) {
        
        int n = nums.size();
        int mod = 1e9 + 7;
        vector<int> cnt(31, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        vector<int> prime(31, 0);
        for (int i = 2; i <= 30; i++) {
            if (prime[i] == 0) {
                for (int j = i; j <= 30; j += i) {
                    if (prime[j] == 0) {
                        prime[j] = i;
                    }
                }
            }
        }
        vector<int> dp(1 << 16, 0);
        dp[0] = 1;
        for (int i = 2; i <= 30; i++) {
            int cur = 0;
            for (int j = i; j <= 30; j += i) {
                cur |= (1 << (j / i - 1));
            }
            for (int j = 0; j < (1 << 16); j++) {
                if (j & cur) {
                    dp[j] = (dp[j] + dp[j ^ cur]) % mod;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < (1 << 16); i++) {
            int num = 0;
            int x = i;
            while (x) {
                x &= (x - 1);
                num++;
            }
            int total = 1;
            int y = i;
            while (y) {
                int k = y & -y;
                int t = 0;
                while (k > 1) {
                    k /= prime[i];
                    t++;
                }
                total *= cnt[t];
                y ^= (y & -y);
            }
            if (num % 2 == 1) {
                ans += total * dp[i];
                ans %= mod;
            } else {
                ans -= total * dp[i];
                ans = (ans % mod + mod) % mod;
            }
        }
        return ans;
    }
};