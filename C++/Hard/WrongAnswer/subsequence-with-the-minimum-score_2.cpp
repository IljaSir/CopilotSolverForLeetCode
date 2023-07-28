class Solution {
public:
    int minimumScore(string s, string t) {
        
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        int res = 0;
        while (i < n && j < m) {
            if (s[i] == t[j]) {
                int i0 = i;
                int j0 = j;
                while (i < n && s[i] == s[i0]) {
                    i++;
                }
                while (j < m && t[j] == t[j0]) {
                    j++;
                }
                res += max(0, j - j0 - i + i0);
            } else {
                i++;
            }
        }
        return res;
    }
};