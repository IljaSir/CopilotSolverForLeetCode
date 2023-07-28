class Solution {
public:
    int makeStringSorted(string s) {
        
        int MOD = 1e9 + 7;
        int N = s.size();
        vector<int> fact(N + 1, 1);
        for (int i = 1; i <= N; ++i)
            fact[i] = 1LL * fact[i - 1] * i % MOD;

        vector<int> count(26, 0);
        int res = 0;
        for (int i = N - 1; i >= 0; --i) {
            int c = s[i] - 'a';
            int less = 0;
            for (int j = 0; j < c; ++j)
                less += count[j];
            res = (res + 1LL * less * fact[N - i - 1]) % MOD;
            for (int j = c; j < 26; ++j)
                count[j]++;
        }
        return res;
    }
};