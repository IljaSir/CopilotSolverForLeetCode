class Solution {
public:
    vector<int> sumPrefixScores(vector<string>& words) {
        
        vector<int> result(words.size());
        for (int i = 0; i < words.size(); ++i) {
            for (int j = 0; j < words[i].size(); ++j) {
                for (int k = 0; k < words.size(); ++k) {
                    if (words[k].find(words[i].substr(0, j + 1)) == 0) {
                        result[i]++;
                    }
                }
            }
        }
        return result;
    }
};