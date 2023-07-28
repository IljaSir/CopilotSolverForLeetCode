class Solution {
public:
    bool isCircularSentence(string sentence) {
        
        int n = sentence.size();
        int start = 0, end = 0;
        while (end < n) {
            while (end < n && sentence[end] != ' ') {
                ++end;
            }
            if (end == n) {
                break;
            }
            if (sentence[start] != sentence[end - 1]) {
                return false;
            }
            start = ++end;
        }
        return sentence[start] == sentence[end - 1];
    }
};