class Solution {
public:
    int strStr(string haystack, string needle) {
        
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) return 0;
        if (n == 0) return -1;
        for (int i = 0; i < n; i++) {
            if (haystack[i] == needle[0]) {
                if (i + m > n) return -1;
                int j = 1;
                while (j < m) {
                    if (haystack[i + j] != needle[j]) break;
                    j++;
                }
                if (j == m) return i;
            }
        }
        return -1;
    }
};