class Solution {
public:
    int countValidWords(string sentence) {
        
        int count = 0;
        bool isWord = false;
        bool isHyphen = false;
        bool isPunctuation = false;
        bool isDigit = false;
        for (int i = 0; i < sentence.size(); i++) {
            if (sentence[i] == ' ') {
                if (isWord && !isHyphen && !isPunctuation && !isDigit) {
                    count++;
                }
                isWord = false;
                isHyphen = false;
                isPunctuation = false;
                isDigit = false;
            } else {
                isWord = true;
                if (sentence[i] == '-' && !isHyphen) {
                    isHyphen = true;
                } else if (sentence[i] == '-' && isHyphen) {
                    isWord = false;
                    isHyphen = false;
                    isPunctuation = false;
                    isDigit = false;
                }
                if (sentence[i] == '!' || sentence[i] == '.' || sentence[i] == ',') {
                    if (!isPunctuation && !isHyphen) {
                        isPunctuation = true;
                    } else {
                        isWord = false;
                        isHyphen = false;
                        isPunctuation = false;
                        isDigit = false;
                    }
                }
                if (isdigit(sentence[i])) {
                    isWord = false;
                    isHyphen = false;
                    isPunctuation = false;
                    isDigit = false;
                }
            }
        }
        if (isWord && !isHyphen && !isPunctuation && !isDigit) {
            count++;
        }
        return count;
    }
};