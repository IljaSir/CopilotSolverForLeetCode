class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        
        int i = 0;
        int j = 0;
        int k = 0;
        int len = sentence.length();
        int len1 = searchWord.length();
        int count = 1;
        while (i < len && j < len1) {
            if (sentence[i] == ' ') {
                count++;
                j = 0;
                i++;
                continue;
            }
            if (sentence[i] == searchWord[j]) {
                i++;
                j++;
                continue;
            }
            else {
                while (i < len && sentence[i] != ' ') {
                    i++;
                }
                count++;
                j = 0;
            }
        }
        if (j == len1) {
            return count;
        }
        return -1;
    }
};