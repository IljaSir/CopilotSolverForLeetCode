class Solution {
public:
    char repeatedCharacter(string s) {
        
        int i = 0;
        int len = s.length();
        int index[26];
        for (i = 0; i < 26; i++) {
            index[i] = len;
        }
        for (i = 0; i < len; i++) {
            if (index[s[i] - 'a'] == len) {
                index[s[i] - 'a'] = i;
            } else {
                index[s[i] - 'a'] = -1;
            }
        }
        int minIndex = len;
        for (i = 0; i < 26; i++) {
            if (index[i] >= 0 && index[i] < minIndex) {
                minIndex = index[i];
            }
        }
        return s[minIndex];
    }
};