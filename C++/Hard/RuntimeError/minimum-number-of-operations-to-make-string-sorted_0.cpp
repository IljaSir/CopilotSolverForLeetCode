class Solution {
public:
    int makeStringSorted(string s) {
        
        int n = s.size();
        int mod = 1e9 + 7;
        vector<int> fact(n + 1, 1);
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            vector<int> cnt(26, 0);
            for (int j = i; j < n; j++) {
                cnt[s[j] - 'a']++;
            }
            for (int j = 0; j < s[i] - 'a'; j++) {
                if (cnt[j] == 0) {
                    continue;
                }
                int cur = fact[n - i - 1];
                for (int k = 0; k < 26; k++) {
                    cur = (cur * pow(fact[cnt[k]], mod - 2, mod)) % mod;
                }
                ans = (ans + cur) % mod;
            }
            cnt[s[i] - 'a']--;
        }
        return ans;
    }
    int pow(int x, int n, int mod) {
        if (n == 0) {
            return 1;
        }
        int half = pow(x, n / 2, mod);
        int ret = (half * half) % mod;
        if (n % 2) {
            ret = (ret * x) % mod;
        }
        return ret;
    }
};