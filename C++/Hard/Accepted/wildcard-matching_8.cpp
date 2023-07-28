class Solution {
public:
    bool isMatch(string s, string p) {
        
        int sLen = s.size();
        int pLen = p.size();
        int sIndex = 0;
        int pIndex = 0;
        int starIndex = -1;
        int matchIndex = 0;
        while (sIndex < sLen) {
            if (pIndex < pLen && (p[pIndex] == '?' || s[sIndex] == p[pIndex])) {
                sIndex++;
                pIndex++;
            } else if (pIndex < pLen && p[pIndex] == '*') {
                starIndex = pIndex;
                matchIndex = sIndex;
                pIndex++;
            } else if (starIndex != -1) {
                pIndex = starIndex + 1;
                matchIndex++;
                sIndex = matchIndex;
            } else {
                return false;
            }
        }
        while (pIndex < pLen && p[pIndex] == '*') {
            pIndex++;
        }
        return pIndex == pLen;
    }
};