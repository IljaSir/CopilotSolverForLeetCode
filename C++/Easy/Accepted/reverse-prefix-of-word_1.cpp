class Solution {
public:
    string reversePrefix(string word, char ch) {
        
        int i;
        for (i = 0; i < word.length(); i++) {
            if (word[i] == ch) {
                break;
            }
        }
        if (i == word.length()) {
            return word;
        }
        int j = 0;
        while (j < i) {
            char t = word[j];
            word[j] = word[i];
            word[i] = t;
            j++;
            i--;
        }
        return word;
    }
};