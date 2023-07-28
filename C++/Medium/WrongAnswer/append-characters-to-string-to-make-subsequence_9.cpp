class Solution {
public:
    int appendCharacters(string s, string t) {
        
        int i = 0, j = 0;
        int n = s.size(), m = t.size();
        int ans = 0;
        while (i < n) {
            if (j < m && s[i] == t[j]) {
                ++i;
                ++j;
            } else {
                ++i;
                ++ans;
            }
        }
        return ans + m - j;
    }
};