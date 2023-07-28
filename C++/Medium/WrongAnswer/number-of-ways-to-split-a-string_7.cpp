class Solution {
public:
    int numWays(string s) {
        
        int n = s.size();
        int mod = 1e9 + 7;
        int cnt = 0;
        for (auto c : s) {
            if (c == '1') cnt++;
        }
        if (cnt == 0) {
            return (long long)(n - 1) * (n - 2) / 2 % mod;
        }
        if (cnt % 3 != 0) return 0;
        int k = cnt / 3;
        int i = 0;
        int m1 = 0, m2 = 0;
        while (k > 0) {
            if (s[i++] == '1') k--;
        }
        while (s[i] == '0') i++;
        m1 = i;
        while (k > 0) {
            if (s[i++] == '1') k--;
        }
        while (s[i] == '0') i++;
        m2 = i - m1;
        return (long long)m1 * m2 % mod;
    }
};