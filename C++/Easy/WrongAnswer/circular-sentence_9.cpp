class Solution {
public:
    bool isCircularSentence(string sentence) {
        
        auto it = sentence.begin();
        auto prevIt = sentence.end() - 1;
        while (it != sentence.end()) {
            if (*it == ' ') {
                if (*prevIt != ' ' && *it != *prevIt) {
                    return false;
                }
            }
            prevIt = it;
            it++;
        }
        if (*prevIt != ' ' && *it != *prevIt) {
            return false;
        }
        return true;
    }
};