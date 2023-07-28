class Solution {
public:
    int squareFreeSubsets(vector<int>& nums) {
        
        int n = nums.size();
        int MOD = 1e9 + 7;
        vector<int> cnt(31);
        for (int num : nums) {
            cnt[num]++;
        }

        vector<int> prime;
        vector<bool> isPrime(31, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i < 31; ++i) {
            if (isPrime[i]) {
                prime.push_back(i);
                for (int j = i * i; j < 31; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        vector<int> dp(1 << prime.size(), 0);
        dp[0] = 1;
        for (int i = 1; i < 31; ++i) {
            int mask = 0;
            for (int j = 0; j < prime.size(); ++j) {
                if (i % prime[j] == 0) {
                    mask |= (1 << j);
                }
            }

            for (int j = (1 << prime.size()) - 1; j >= 0; --j) {
                for (int k = 1; k <= cnt[i]; ++k) {
                    int nj = j ^ (mask * k);
                    dp[nj] = (dp[nj] + dp[j]) % MOD;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < (1 << prime.size()); ++i) {
            int c = __builtin_popcount(i);
            if (c % 2 == 0) {
                ans = (ans + dp[i]) % MOD;
            }
            else {
                ans = (ans - dp[i] + MOD) % MOD;
            }
        }

        return ans;
    }
};