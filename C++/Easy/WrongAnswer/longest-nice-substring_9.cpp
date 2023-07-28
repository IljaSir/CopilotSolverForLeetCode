class Solution {
public:
    string longestNiceSubstring(string s) {
        
        int n = s.size();
        if(n <= 1) return "";
        for(int i=0; i<n; i++) {
            if(s[i] >= 'a' && s[i] <= 'z') {
                if(s.find(toupper(s[i])) == string::npos) {
                    string s1 = longestNiceSubstring(s.substr(0, i));
                    string s2 = longestNiceSubstring(s.substr(i+1));
                    return s1.size() > s2.size() ? s1 : s2;
                }
            } else {
                if(s.find(tolower(s[i])) == string::npos) {
                    string s1 = longestNiceSubstring(s.substr(0, i));
                    string s2 = longestNiceSubstring(s.substr(i+1));
                    return s1.size() > s2.size() ? s1 : s2;
                }
            }
        }
        return s;
    }
};