class Solution {
public:
    int countSubstrings(string s, string t) {
        
        int res = 0;
        for (int i = 0; i < s.size(); ++i) {
            for (int j = 0; j < t.size(); ++j) {
                int diff = 0;
                for (int k = 0; i + k < s.size() && j + k < t.size() && diff <= 1; ++k) {
                    if (s[i + k] != t[j + k]) {
                        ++diff;
                    }
                    if (diff == 1) {
                        ++res;
                    }
                }
            }
        }
        return res;
    }
};