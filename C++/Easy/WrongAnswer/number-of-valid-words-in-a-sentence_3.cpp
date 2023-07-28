class Solution {
public:
    int countValidWords(string sentence) {
        
        int count = 0;
        bool isWord = false;
        bool isHyphen = false;
        bool isPunctuation = false;
        for (int i = 0; i < sentence.size(); i++) {
            if (sentence[i] == ' ') {
                if (isWord) {
                    count++;
                }
                isWord = false;
                isHyphen = false;
                isPunctuation = false;
            } else if (sentence[i] == '-') {
                if (isHyphen) {
                    isWord = false;
                } else {
                    isHyphen = true;
                }
            } else if (sentence[i] == '!' || sentence[i] == '.' || sentence[i] == ',') {
                if (isPunctuation) {
                    isWord = false;
                } else {
                    isPunctuation = true;
                }
            } else {
                if (isPunctuation) {
                    isWord = false;
                } else {
                    isWord = true;
                }
            }
        }
        if (isWord) {
            count++;
        }
        return count;
    }
};