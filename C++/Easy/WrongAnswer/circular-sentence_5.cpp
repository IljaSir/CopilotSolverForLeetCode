class Solution {
public:
    bool isCircularSentence(string sentence) {
        
        int i = 0;
        int j = 0;
        int n = sentence.size();
        while (i < n) {
            while (i < n && sentence[i] != ' ') {
                ++i;
            }
            if (sentence[i - 1] != sentence[j]) {
                return false;
            }
            ++i;
            j = i;
        }
        return true;
    }
};