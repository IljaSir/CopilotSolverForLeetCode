class Solution {
public:
    string makeFancyString(string s) {
        
        int n = s.size();
        if(n <= 2) return s;
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n){
            j = i;
            while(j < n && s[j] == s[i]) j++;
            k = min(2, j-i);
            while(k--) s[i++] = s[j-1];
        }
        return s.substr(0, i);
    }
};