class Solution {
public:
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        
        vector<bool> res;
        for (int i = 0; i < queries.size(); ++i) {
            int j = 0;
            for (int k = 0; k < queries[i].size(); ++k) {
                if (j < pattern.size() && pattern[j] == queries[i][k]) {
                    ++j;
                } else if (queries[i][k] >= 'A' && queries[i][k] <= 'Z') {
                    j = -1;
                    break;
                }
            }
            res.push_back(j == pattern.size());
        }
        return res;
    }
};