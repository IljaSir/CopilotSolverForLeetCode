class Solution {
public:
    int countSubstrings(string s, string t) {
        
        int n = s.size(), m = t.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; i + k < n && j + k < m; k++) {
                    if (s[i + k] != t[j + k]) {
                        count += m - j - k;
                        break;
                    }
                }
            }
        }
        return count;
    }
};