class Solution {
public:
    char repeatedCharacter(string s) {
        
        int count[26] = {0};
        for (char c : s) {
            if (++count[c - 'a'] == 2) {
                return c;
            }
        }
        return ' ';
    }
};