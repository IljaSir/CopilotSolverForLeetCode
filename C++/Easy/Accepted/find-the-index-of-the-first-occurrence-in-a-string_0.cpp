class Solution {
public:
    int strStr(string haystack, string needle) {
        
        if(needle.size() == 0) return 0;
        if(haystack.size() == 0) return -1;
        for(int i = 0; i < haystack.size(); i++){
            if(haystack[i] == needle[0]){
                int j = 1;
                for(; j < needle.size(); j++){
                    if(haystack[i + j] != needle[j]) break;
                }
                if(j == needle.size()) return i;
            }
        }
        return -1;
    }
};