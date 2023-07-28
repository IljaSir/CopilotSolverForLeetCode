class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        
        int count = 1;
        for (int i = 0; i < sentence.size(); i++) {
            if (sentence[i] == ' ') {
                count++;
            }
            if (sentence[i] == searchWord[0]) {
                int j = 0;
                for (; j < searchWord.size(); j++) {
                    if (sentence[i + j] != searchWord[j]) {
                        break;
                    }
                }
                if (j == searchWord.size()) {
                    return count;
                }
            }
        }
        return -1;
    }
};