class Solution {
public:
    string longestPrefix(string s) {
        
        int n = s.size();
        int i = 0, j = n - 1;
        while (i < j) {
            if (s[i] == s[j]) {
                ++i;
                --j;
            } else {
                i = 0;
                --j;
            }
        }
        return s.substr(0, i);
    }
};