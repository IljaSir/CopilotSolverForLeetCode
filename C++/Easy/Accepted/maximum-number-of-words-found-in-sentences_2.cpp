class Solution {
public:
    int mostWordsFound(vector<string>& sentences) {
        
        int max = 0;
        for (string sentence : sentences) {
            int count = 1;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence[i] == ' ') {
                    count++;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
};