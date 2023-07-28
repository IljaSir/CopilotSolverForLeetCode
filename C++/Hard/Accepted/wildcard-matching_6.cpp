class Solution {
public:
    bool isMatch(string s, string p) {
        
        int sLen = s.size(), pLen = p.size();
        int i = 0, j = 0;
        int iStar = -1, jStar = -1;
        while (i < sLen) {
            if (j < pLen && (s[i] == p[j] || p[j] == '?')) {
                i++;
                j++;
            } else if (j < pLen && p[j] == '*') {
                iStar = i;
                jStar = j;
                j++;
            } else if (iStar >= 0) {
                iStar++;
                i = iStar;
                j = jStar + 1;
            } else {
                return false;
            }
        }
        while (j < pLen && p[j] == '*') {
            j++;
        }
        return j == pLen;
    }
};