class Solution {
public:
    int makeStringSorted(string s) {
        
        int n = s.length();
        int mod = 1e9 + 7;
        vector<int> fact(n + 1, 1);
        for (int i = 1; i <= n; i++) {
            fact[i] = 1ll * fact[i - 1] * i % mod;
        }
        int ans = 0;
        vector<int> cnt(26, 0);
        for (int i = n - 1; i >= 0; i--) {
            int c = s[i] - 'a';
            int smaller = 0;
            for (int j = 0; j < c; j++) {
                smaller += cnt[j];
            }
            ans = (ans + 1ll * smaller * fact[n - i - 1]) % mod;
            for (int j = c + 1; j < 26; j++) {
                ans = (ans + 1ll * cnt[j] * fact[n - i - 1]) % mod;
            }
            cnt[c]++;
        }
        return ans;
    }
};