class Solution {
public:
    int mostWordsFound(vector<string>& sentences) {
        
        int maxWords = 0;
        for (auto& sentence : sentences) {
            int words = 1;
            for (auto& c : sentence) {
                if (c == ' ') {
                    words++;
                }
            }
            if (words > maxWords) {
                maxWords = words;
            }
        }
        return maxWords;
    }
};