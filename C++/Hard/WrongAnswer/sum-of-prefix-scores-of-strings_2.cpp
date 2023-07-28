class Solution {
public:
    vector<int> sumPrefixScores(vector<string>& words) {
        
        vector<int> res;
        for (int i = 0; i < words.size(); ++i) {
            int sum = 0;
            for (int j = 0; j < words[i].size(); ++j) {
                for (int k = i; k < words.size(); ++k) {
                    if (words[k].size() < j + 1) continue;
                    if (words[k].substr(0, j + 1) == words[i].substr(0, j + 1)) {
                        ++sum;
                    }
                }
            }
            res.push_back(sum);
        }
        return res;
    }
};