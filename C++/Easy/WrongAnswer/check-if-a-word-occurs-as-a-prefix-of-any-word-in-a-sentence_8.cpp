class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        
        int i = 1;
        int len = sentence.length();
        int len2 = searchWord.length();
        bool flag = false;
        for(int j = 0; j < len; j++) {
            if(sentence[j] == ' ') {
                i++;
                flag = false;
            }
            else if(sentence[j] == searchWord[0]) {
                if(len - j >= len2) {
                    int k = 0;
                    while(k < len2) {
                        if(sentence[j + k] != searchWord[k]) {
                            break;
                        }
                        k++;
                    }
                    if(k == len2) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        if(flag) {
            return i;
        }
        else {
            return -1;
        }
    }
};