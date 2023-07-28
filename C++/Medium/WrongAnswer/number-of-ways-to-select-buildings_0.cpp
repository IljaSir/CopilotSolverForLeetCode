class Solution {
public:
    long long numberOfWays(string s) {
        
        int n = s.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '1') ++cnt;
        }
        if (cnt % 3 != 0) return 0;
        if (cnt == 0) {
            return (long long)(n - 2) * (long long)(n - 1) / 2 % 1000000007;
        }
        int m = cnt / 3;
        int l = 0, r = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '1') {
                ++l;
                if (l == m) {
                    l = i;
                    break;
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (s[i] == '1') {
                ++r;
                if (r == m) {
                    r = i;
                    break;
                }
            }
        }
        l = l + 1;
        r = r - 1;
        int left = 0, right = 0;
        for (int i = l; i <= r; ++i) {
            if (s[i] == '0') ++left;
        }
        for (int i = r; i >= l; --i) {
            if (s[i] == '0') ++right;
        }
        return (long long)left * (long long)right % 1000000007;
    }
};