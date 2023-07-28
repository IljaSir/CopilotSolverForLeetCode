class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        
        int index = 1;
        string word;
        string::size_type pos;
        while ((pos = sentence.find(' ')) != string::npos) {
            word = sentence.substr(0, pos);
            if (word.find(searchWord) == 0) {
                return index;
            }
            sentence.erase(0, pos + 1);
            index++;
        }
        if (sentence.find(searchWord) == 0) {
            return index;
        }
        return -1;
    }
};