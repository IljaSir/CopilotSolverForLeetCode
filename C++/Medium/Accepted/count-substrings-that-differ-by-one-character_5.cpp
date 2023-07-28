class Solution {
public:
    int countSubstrings(string s, string t) {
        
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < t.length(); ++j) {
                int cnt = 0;
                for (int k = 0; i + k < s.length() && j + k < t.length(); ++k) {
                    if (s[i + k] != t[j + k]) {
                        ++cnt;
                    }
                    if (cnt == 1) {
                        ++res;
                    } else if (cnt > 1) {
                        break;
                    }
                }
            }
        }
        return res;
    }
};