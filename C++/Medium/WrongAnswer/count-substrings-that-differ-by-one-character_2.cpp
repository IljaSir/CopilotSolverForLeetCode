class Solution {
public:
    int countSubstrings(string s, string t) {
        
        int n = s.size(), m = t.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int k = 0; k < min(n - i, m - j); ++k) {
                    if (s[i + k] != t[j + k] && k + 1 >= ans) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }
};