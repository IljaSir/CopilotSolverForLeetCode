class Solution {
public:
    long long numberOfWays(string s) {
        
        int n = s.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            cnt += s[i] == '1';
        }
        if (cnt % 3 != 0) return 0;
        if (cnt == 0) {
            long long res = 1ll * (n - 1) * (n - 2) / 2;
            return res % 1000000007;
        }
        cnt /= 3;
        int i = 0, j = 0, k = 0;
        int c = 0;
        for (int l = 0; l < n; ++l) {
            if (s[l] == '1') c++;
            if (c == cnt) {i = l; break;}
        }
        for (int l = i + 1; l < n; ++l) {
            if (s[l] == '1') c++;
            if (c == 2 * cnt) {j = l; break;}
        }
        for (int l = j + 1; l < n; ++l) {
            if (s[l] == '1') c++;
            if (c == 3 * cnt) {k = l; break;}
        }
        long long res = 1ll * (i + 1) * (j - i) * (k - j);
        return res % 1000000007;
    }
};