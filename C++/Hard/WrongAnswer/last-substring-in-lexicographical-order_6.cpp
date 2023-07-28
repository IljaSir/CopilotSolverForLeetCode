class Solution {
public:
    string lastSubstring(string s) {
        
        int n = s.size();
        int i = 0, j = 1;
        while (j < n) {
            if (s[i] == s[j]) {
                i++;
                j++;
            } else if (s[i] < s[j]) {
                i = j;
                j++;
            } else {
                j++;
            }
        }
        return s.substr(i);
    }
};