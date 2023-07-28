class Solution {
public:
    bool isMatch(string s, string p) {
        
        int sLen = s.length();
        int pLen = p.length();
        int sIdx = 0;
        int pIdx = 0;
        int starIdx = -1;
        int sTmpIdx = -1;
        while (sIdx < sLen) {
            if (pIdx < pLen && (p[pIdx] == '?' || p[pIdx] == s[sIdx])) {
                sIdx++;
                pIdx++;
            } else if (pIdx < pLen && p[pIdx] == '*') {
                starIdx = pIdx;
                pIdx++;
                sTmpIdx = sIdx;
            } else if (starIdx != -1) {
                pIdx = starIdx + 1;
                sTmpIdx++;
                sIdx = sTmpIdx;
            } else {
                return false;
            }
        }
        while (pIdx < pLen && p[pIdx] == '*') {
            pIdx++;
        }
        return pIdx == pLen;
    }
};