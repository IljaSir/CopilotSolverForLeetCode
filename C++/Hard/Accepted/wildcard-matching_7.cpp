class Solution {
public:
    bool isMatch(string s, string p) {
        
        int sLen = s.length();
        int pLen = p.length();
        int sIndex = 0;
        int pIndex = 0;
        int sStar = -1;
        int pStar = -1;
        while (sIndex < sLen) {
            if (pIndex < pLen && (s[sIndex] == p[pIndex] || p[pIndex] == '?')) {
                ++sIndex;
                ++pIndex;
            } else if (pIndex < pLen && p[pIndex] == '*') {
                sStar = sIndex;
                pStar = pIndex;
                ++pIndex;
            } else if (sStar != -1) {
                sIndex = ++sStar;
                pIndex = pStar + 1;
            } else {
                return false;
            }
        }
        while (pIndex < pLen && p[pIndex] == '*') {
            ++pIndex;
        }
        return pIndex == pLen;
    }
};