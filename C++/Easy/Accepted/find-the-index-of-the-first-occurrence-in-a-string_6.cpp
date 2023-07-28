class Solution {
public:
    int strStr(string haystack, string needle) {
        
        if (needle.empty())
            return 0;
        if (haystack.empty())
            return -1;
        int hLen = haystack.length();
        int nLen = needle.length();
        if (hLen < nLen)
            return -1;
        for (int i = 0; i < hLen; i++) {
            if (haystack[i] == needle[0]) {
                if (i + nLen > hLen)
                    return -1;
                int j = 1;
                while (j < nLen && haystack[i + j] == needle[j])
                    j++;
                if (j == nLen)
                    return i;
            }
        }
        return -1;
    }
};