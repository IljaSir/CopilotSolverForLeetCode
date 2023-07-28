class Solution {
public:
    int makeStringSorted(string s) {
        
        int n = s.size();
        int cnt[26] = {0};
        int fac[n+1];
        fac[0] = 1;
        for (int i = 1; i <= n; ++i) {
            fac[i] = 1ll * fac[i-1] * i % 1000000007;
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int less = 0;
            for (int j = s[i] - 'a' + 1; j < 26; ++j) {
                less = (less + cnt[j]) % 1000000007;
            }
            res = (res + 1ll * less * fac[n-i-1]) % 1000000007;
            for (int j = s[i] - 'a'; j >= 0; --j) {
                cnt[j] = (cnt[j] + fac[n-i-1]) % 1000000007;
            }
        }
        return res;
    }
};