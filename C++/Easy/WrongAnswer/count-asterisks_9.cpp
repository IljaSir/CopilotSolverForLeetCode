class Solution {
public:
    int countAsterisks(string s) {
        
        int i, n = s.size(), count = 0;
        for (i = 0; i < n; ++i) {
            if (s[i] == '*') {
                count++;
            }
            else if (s[i] == '|') {
                i++;
            }
        }
        return count;
    }
};