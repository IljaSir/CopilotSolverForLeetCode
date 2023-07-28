class Solution {
public:
    int mostWordsFound(vector<string>& sentences) {
        
        int maxWords = 0;
        for (auto sentence : sentences) {
            int words = 0;
            for (int i = 0; i < sentence.length(); ++i) {
                if (sentence[i] == ' ') {
                    words++;
                }
            }
            maxWords = max(maxWords, words + 1);
        }
        return maxWords;
    }
};