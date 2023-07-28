class Solution {
public:
    int strStr(string haystack, string needle) {
        
        int n = haystack.length();
        int m = needle.length();
        if(m == 0) return 0;
        for(int i = 0; i < n; i++){
            if(haystack[i] == needle[0]){
                if(n - i < m) return -1;
                for(int j = 1; j < m; j++){
                    if(haystack[i + j] != needle[j]) break;
                    if(j == m - 1) return i;
                }
            }
        }
        return -1;
    }
};