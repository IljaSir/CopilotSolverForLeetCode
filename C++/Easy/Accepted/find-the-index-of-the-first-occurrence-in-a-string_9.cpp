class Solution {
public:
    int strStr(string haystack, string needle) {
        
        if(needle.empty()) return 0;
        if(haystack.empty()) return -1;
        int i = 0;
        int j = 0;
        int n = haystack.size();
        int m = needle.size();
        while(i < n && j < m){
            if(haystack[i] == needle[j]){
                i++;
                j++;
            }else{
                i = i - j + 1;
                j = 0;
            }
        }
        if(j == m) return i - m;
        else return -1;
    }
};