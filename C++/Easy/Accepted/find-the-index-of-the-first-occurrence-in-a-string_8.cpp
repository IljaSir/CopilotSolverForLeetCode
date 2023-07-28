class Solution {
public:
    int strStr(string haystack, string needle) {
        
        if (needle.empty()) return 0;
        if (haystack.empty()) return -1;
        int i = 0;
        int j = 0;
        int m = haystack.size();
        int n = needle.size();
        while (i < m && j < n) {
            if (haystack[i] == needle[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == n) return i - j;
        return -1;
    }
};