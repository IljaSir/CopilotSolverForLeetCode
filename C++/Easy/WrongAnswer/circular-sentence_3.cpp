class Solution {
public:
    bool isCircularSentence(string sentence) {
        
        int i = 0;
        int j = 0;
        int n = sentence.size();
        while (j < n) {
            while (j < n && sentence[j] != ' ') {
                j++;
            }
            if (j < n && sentence[j] == ' ' && sentence[i] != sentence[j - 1]) {
                return false;
            }
            j++;
            i = j;
        }
        return sentence[0] == sentence[n - 1];
    }
};