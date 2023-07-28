class Solution {
public:
    int canBeTypedWords(string text, string brokenLetters) {
        
        int count = 0;
        bool flag = true;
        for (int i = 0; i < text.length(); i++) {
            if (text[i] == ' ') {
                if (flag) {
                    count++;
                }
                flag = true;
            } else {
                if (brokenLetters.find(text[i]) != string::npos) {
                    flag = false;
                }
            }
        }
        if (flag) {
            count++;
        }
        return count;
    }
};