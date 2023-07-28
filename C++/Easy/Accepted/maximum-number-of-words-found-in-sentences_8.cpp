class Solution {
public:
    int mostWordsFound(vector<string>& sentences) {
        
        int maxWords = 0;
        for (auto sentence: sentences) {
            int count = 0;
            for (auto c: sentence) {
                if (c == ' ') {
                    count++;
                }
            }
            maxWords = max(maxWords, count+1);
        }
        return maxWords;
    }
};