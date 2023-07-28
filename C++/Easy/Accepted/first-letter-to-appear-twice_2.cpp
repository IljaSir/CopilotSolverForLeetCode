class Solution {
public:
    char repeatedCharacter(string s) {
        
        int n = s.size();
        int count[26] = {0};
        for (int i = 0; i < n; i++) {
            count[s[i] - 'a']++;
            if (count[s[i] - 'a'] == 2) {
                return s[i];
            }
        }
        return ' ';
    }
};