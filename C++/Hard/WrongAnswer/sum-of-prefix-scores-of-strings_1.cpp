class Solution {
public:
    vector<int> sumPrefixScores(vector<string>& words) {
        
        vector<int> result;
        for (int i = 0; i < words.size(); i++) {
            int score = 0;
            for (int j = 0; j < words.size(); j++) {
                if (i != j) {
                    if (words[j].find(words[i]) == 0) {
                        score++;
                    }
                }
            }
            result.push_back(score);
        }
        return result;
    }
};