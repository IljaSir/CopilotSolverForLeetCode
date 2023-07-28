class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        
        int index = 0;
        int wordIndex = 1;
        while (index < sentence.size()) {
            int i = index;
            int j = 0;
            while (i < sentence.size() && j < searchWord.size() && sentence[i] == searchWord[j]) {
                i++;
                j++;
            }
            if (j == searchWord.size()) {
                return wordIndex;
            }
            while (i < sentence.size() && sentence[i] != ' ') {
                i++;
            }
            index = i + 1;
            wordIndex++;
        }
        return -1;
    }
};