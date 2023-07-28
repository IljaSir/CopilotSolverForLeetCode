class Solution {
public:
    int canBeTypedWords(string text, string brokenLetters) {
        
        int count = 0;
        for (int i = 0; i < text.size(); i++) {
            bool flag = true;
            while (i < text.size() && text[i] != ' ') {
                if (brokenLetters.find(text[i]) != string::npos) {
                    flag = false;
                    break;
                }
                i++;
            }
            if (flag) count++;
        }
        return count;
    }
};