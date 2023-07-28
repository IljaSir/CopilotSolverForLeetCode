class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        
        int index = 0;
        int res = -1;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence[i] == ' ') {
                index++;
            }
            else {
                int j = 0;
                while (j < searchWord.length() && i + j < sentence.length() && sentence[i + j] == searchWord[j]) {
                    j++;
                }
                if (j == searchWord.length()) {
                    res = index + 1;
                    break;
                }
            }
        }
        return res;
    }
};