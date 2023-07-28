class Solution {
public:
    int minimumScore(string s, string t) {
        
        int n = s.size(), m = t.size();
        int i = 0, j = 0;
        int res = 0;
        while (i < n && j < m) {
            if (s[i] == t[j]) {
                int tmp1 = i, tmp2 = j;
                while (i < n && j < m && s[i] == t[j]) {
                    ++i; ++j;
                }
                res += max(0, i - tmp1 - 1);
            } else {
                ++i;
            }
        }
        return res;
    }
};