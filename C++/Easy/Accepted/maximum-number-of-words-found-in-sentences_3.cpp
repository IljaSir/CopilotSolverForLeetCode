class Solution {
public:
    int mostWordsFound(vector<string>& sentences) {
        
        int maxWords = 0;
        for (auto sentence : sentences) {
            int count = 0;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence[i] == ' ') {
                    count++;
                }
            }
            if (maxWords < count) {
                maxWords = count;
            }
        }
        return maxWords + 1;
    }
};