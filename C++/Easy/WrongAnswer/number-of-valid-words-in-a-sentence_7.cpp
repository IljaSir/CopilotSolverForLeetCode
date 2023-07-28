class Solution {
public:
    int countValidWords(string sentence) {
        
        int count = 0;
        bool isWord = false;
        bool isHyphen = false;
        bool isPunct = false;
        for(int i = 0; i < sentence.length(); i++) {
            if(sentence[i] == ' ') {
                if(isWord && !isHyphen && !isPunct) {
                    count++;
                }
                isWord = false;
                isHyphen = false;
                isPunct = false;
            } else {
                if(sentence[i] >= 'a' && sentence[i] <= 'z') {
                    isWord = true;
                } else if(sentence[i] == '-') {
                    if(isHyphen) {
                        isWord = false;
                    }
                    isHyphen = true;
                } else if(sentence[i] == '!' || sentence[i] == '.' || sentence[i] == ',') {
                    if(isPunct) {
                        isWord = false;
                    }
                    isPunct = true;
                } else {
                    isWord = false;
                }
            }
        }
        if(isWord && !isHyphen && !isPunct) {
            count++;
        }
        return count;
    }
};