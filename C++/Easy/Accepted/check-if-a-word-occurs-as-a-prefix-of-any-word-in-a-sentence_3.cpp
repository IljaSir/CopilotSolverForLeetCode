class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        
        int index = 1;
        string tmp;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence[i] == ' ') {
                index++;
                continue;
            }
            tmp = "";
            while (i < sentence.length() && sentence[i] != ' ') {
                tmp += sentence[i++];
            }
            if (tmp.length() >= searchWord.length() && tmp.substr(0, searchWord.length()) == searchWord) {
                return index;
            }
            index++;
        }
        return -1;
    }
};