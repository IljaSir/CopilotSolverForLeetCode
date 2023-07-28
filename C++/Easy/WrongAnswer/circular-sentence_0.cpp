class Solution {
public:
    bool isCircularSentence(string sentence) {
        
        int n = sentence.size();
        char c = sentence[0];
        for (int i = 1; i < n; i++) {
            if (sentence[i] == ' ') {
                c = sentence[i + 1];
            } else if (sentence[i] != c) {
                return false;
            }
        }
        return true;
    }
};