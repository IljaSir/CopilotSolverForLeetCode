class Solution {
public:
    string longestNiceSubstring(string s) {
        
        int n = s.size();
        for(int i = 0; i < n; i++){
            if(islower(s[i]) && find(s.begin(), s.end(), toupper(s[i])) == s.end())
                return max(longestNiceSubstring(s.substr(0, i)), longestNiceSubstring(s.substr(i+1)));
            else if(isupper(s[i]) && find(s.begin(), s.end(), tolower(s[i])) == s.end())
                return max(longestNiceSubstring(s.substr(0, i)), longestNiceSubstring(s.substr(i+1)));
        }
        return s;
    }
};