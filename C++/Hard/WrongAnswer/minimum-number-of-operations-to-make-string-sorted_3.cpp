class Solution {
public:
    int makeStringSorted(string s) {
        
        int res = 0;
        int n = s.size();
        vector<int> fact(n + 1, 1);
        for (int i = 1; i <= n; ++i) {
            fact[i] = (long long)fact[i - 1] * i % 1000000007;
        }
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            for (int j = i + 1; j < n; ++j) {
                if (s[j] < s[i]) {
                    ++cnt;
                }
            }
            res = (res + (long long)cnt * fact[n - i - 1]) % 1000000007;
            for (int j = i + 1; j < n; ++j) {
                if (s[j] == s[i]) {
                    swap(s[j], s[i]);
                    break;
                }
            }
        }
        return res;
    }
};