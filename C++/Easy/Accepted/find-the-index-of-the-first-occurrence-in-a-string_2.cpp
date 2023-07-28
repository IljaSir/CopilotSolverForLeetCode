class Solution {
public:
    int strStr(string haystack, string needle) {
        
        int n = haystack.size();
        int m = needle.size();
        if (n < m) return -1;
        if (m == 0) return 0;
        for (int i = 0; i <= n - m; i++) {
            if (haystack[i] == needle[0]) {
                int j = 1;
                for (; j < m; j++) {
                    if (haystack[i + j] != needle[j])
                        break;
                }
                if (j == m)
                    return i;
            }
        }
        return -1;
    }
};