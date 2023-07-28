class Solution {
public:
    int makeStringSorted(string s) {
        
        int n = s.size();
        vector<int> fact(n + 1);
        fact[0] = 1;
        for (int i = 1; i <= n; ++i)
            fact[i] = (long long)fact[i - 1] * i % mod;
        vector<int> cnt(26);
        int res = 0;
        for (int i = n - 1; i >= 0; --i) {
            int cur = 0;
            for (int j = 0; j < s[i] - 'a'; ++j)
                cur = (cur + cnt[j]) % mod;
            res = (res + (long long)cur * fact[n - i - 1]) % mod;
            ++cnt[s[i] - 'a'];
        }
        return res;
    }
};