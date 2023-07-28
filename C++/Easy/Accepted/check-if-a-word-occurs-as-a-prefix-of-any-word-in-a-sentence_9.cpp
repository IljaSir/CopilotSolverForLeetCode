class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        
        int len = sentence.size();
        int pos = 0;
        int pos2 = 0;
        int i = 1;
        while(pos < len){
            pos2 = sentence.find(' ', pos);
            if(pos2 == string::npos) pos2 = len;
            if(pos2 - pos >= searchWord.size() && sentence.substr(pos, searchWord.size()) == searchWord) return i;
            pos = pos2 + 1;
            i++;
        }
        return -1;
    }
};