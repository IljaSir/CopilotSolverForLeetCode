class Solution {
public:
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        
        vector<bool> res;
        for (auto& query : queries) {
            int i = 0;
            int j = 0;
            for (; i < query.size() && j < pattern.size(); ++i) {
                if (query[i] == pattern[j]) {
                    ++j;
                } else if (query[i] >= 'A' && query[i] <= 'Z') {
                    break;
                }
            }
            if (j == pattern.size()) {
                for (; i < query.size(); ++i) {
                    if (query[i] >= 'A' && query[i] <= 'Z') {
                        break;
                    }
                }
            }
            res.push_back(i == query.size());
        }
        return res;
    }
};