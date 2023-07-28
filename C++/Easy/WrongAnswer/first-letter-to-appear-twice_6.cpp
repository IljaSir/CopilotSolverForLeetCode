class Solution {
public:
    char repeatedCharacter(string s) {
        
        int count = 0;
        char letter;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s[i] == s[j]) {
                    count++;
                    letter = s[i];
                    break;
                }
            }
            if (count > 0) {
                break;
            }
        }
        return letter;
    }
};