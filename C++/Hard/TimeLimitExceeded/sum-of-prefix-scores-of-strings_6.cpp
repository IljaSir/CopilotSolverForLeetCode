class Solution {
public:
    vector<int> sumPrefixScores(vector<string>& words) {
        
        map<string, int> scores;
        for (int i = 0; i < words.size(); ++i) {
            for (int j = 0; j < words[i].size(); ++j) {
                string prefix = words[i].substr(0, j+1);
                scores[prefix]++;
            }
        }
        vector<int> ans;
        for (int i = 0; i < words.size(); ++i) {
            int score = 0;
            for (int j = 0; j < words[i].size(); ++j) {
                string prefix = words[i].substr(0, j+1);
                score += scores[prefix];
            }
            ans.push_back(score);
        }
        return ans;
    }
};