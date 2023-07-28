class Solution {
public:
    int numDecodings(string s) {
        
        int n = s.size();
        const int mod = 1e9 + 7;
        vector<long long> f(n + 1);
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s[i - 1] == '0') {
                if (i == 1 || s[i - 2] == '0' || s[i - 2] >= '3') {
                    return 0;
                }
                f[i] = f[i - 2];
            } else if (s[i - 1] == '*') {
                f[i] = 9 * f[i - 1];
                if (i > 1) {
                    if (s[i - 2] == '1') {
                        f[i] = (f[i] + 9 * f[i - 2]) % mod;
                    } else if (s[i - 2] == '2') {
                        f[i] = (f[i] + 6 * f[i - 2]) % mod;
                    } else if (s[i - 2] == '*') {
                        f[i] = (f[i] + 15 * f[i - 2]) % mod;
                    }
                }
            } else {
                f[i] = f[i - 1];
                if (i > 1 && s[i - 2] != '0') {
                    int ten = (s[i - 2] - '0') * 10;
                    int one = s[i - 1] - '0';
                    if (ten + one <= 26) {
                        f[i] = (f[i] + f[i - 2]) % mod;
                    }
                }
            }
        }
        return f[n];
    }
};