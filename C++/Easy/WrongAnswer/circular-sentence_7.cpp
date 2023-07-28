class Solution {
public:
    bool isCircularSentence(string sentence) {
        
        int sz = sentence.size();
        int i = 0;
        int j = 0;
        for(; i < sz; ++i) {
            if(sentence[i] == ' ') {
                if(sentence[j] != sentence[i-1]) {
                    return false;
                }
                j = i + 1;
            }
        }
        if(sentence[j] != sentence[i-1]) {
            return false;
        }
        return true;
    }
};