class Solution {
public:
    bool hasAllCodes(string s, int k) {
        
        int n = s.size();
        if (n < k) return false;
        int m = 1 << k;
        vector<bool> f(m, false);
        int mask = m - 1;
        int v = 0;
        for (int i = 0; i < k; i++) {
            v = v << 1;
            v |= s[i] - '0';
        }
        f[v] = true;
        for (int i = k; i < n; i++) {
            v = v << 1;
            v |= s[i] - '0';
            v &= mask;
            f[v] = true;
        }
        for (int i = 0; i < m; i++) {
            if (!f[i]) return false;
        }
        return true;
    }
};