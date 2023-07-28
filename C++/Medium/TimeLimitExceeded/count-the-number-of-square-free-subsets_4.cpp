class Solution {
public:
    int squareFreeSubsets(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> count(31, 0);
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        int mod = 1e9 + 7;
        vector<int> dp(1 << 30, 0);
        dp[0] = 1;
        for (int i = 1; i < (1 << 30); i++) {
            int j = 0;
            while ((i & (1 << j)) == 0) {
                j++;
            }
            dp[i] = dp[i ^ (1 << j)] * (count[j] + 1) % mod;
        }
        vector<int> prime;
        vector<bool> isPrime(31, true);
        for (int i = 2; i <= 30; i++) {
            if (isPrime[i]) {
                prime.push_back(i);
                for (int j = i * i; j <= 30; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < (1 << 30); i++) {
            int cnt = 0;
            int j = 0;
            while ((i & (1 << j)) == 0) {
                j++;
            }
            int x = j;
            while (x <= 30) {
                if (i & (1 << x)) {
                    cnt++;
                }
                x += j;
            }
            if (cnt % 2 == 0) {
                ans += dp[i];
            } else {
                ans -= dp[i];
            }
            ans = (ans % mod + mod) % mod;
        }
        return ans;
    }
};