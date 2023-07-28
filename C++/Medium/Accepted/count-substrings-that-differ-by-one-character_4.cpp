class Solution {
public:
    int countSubstrings(string s, string t) {
        
        int res = 0;
        int m = s.size(), n = t.size();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int cnt = 0;
                for (int k = 0; i + k < m && j + k < n; ++k) {
                    if (s[i + k] != t[j + k]) {
                        if (++cnt > 1) break;
                    }
                    res += cnt;
                }
            }
        }
        return res;
    }
};