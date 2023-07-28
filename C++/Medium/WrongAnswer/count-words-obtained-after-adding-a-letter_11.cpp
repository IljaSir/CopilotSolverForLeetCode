class Solution {
public:
    int wordCount(vector<string>& startWords, vector<string>& targetWords) {
        
        int ans = 0;
        for (string& targetWord : targetWords) {
            for (string& startWord : startWords) {
                if (startWord.size() > targetWord.size()) continue;
                int i = 0, j = 0;
                for (; i < startWord.size() && j < targetWord.size(); ++j) {
                    if (startWord[i] == targetWord[j]) ++i;
                }
                if (i == startWord.size()) {
                    ans += 1;
                    break;
                }
            }
        }
        return ans;
    }
};