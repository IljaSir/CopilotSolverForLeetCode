class Solution {
public:
    string lastSubstring(string s) {
        
        int len = s.size();
        int start = 0;
        int end = 1;
        int k = 0;
        while(end + k < len) {
            if (s[start + k] == s[end + k]) {
                k++;
            } else if (s[start + k] < s[end + k]) {
                start = end;
                end = start + 1;
                k = 0;
            } else {
                end += k + 1;
                k = 0;
            }
        }
        return s.substr(start);
    }
};