class Solution {
public:
    int countSubstrings(string s) {
        
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; i - j >= 0 && i + j < len; ++j) {
                if (s[i - j] != s[i + j]) {
                    break;
                }
                ++ans;
            }
            for (int j = 0; i - j >= 0 && i + j + 1 < len; ++j) {
                if (s[i - j] != s[i + j + 1]) {
                    break;
                }
                ++ans;
            }
        }
        return ans;
    }
};