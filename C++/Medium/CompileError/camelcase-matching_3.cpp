class Solution {
public:
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        
        vector<bool> res;
        for (auto& query : queries) {
            res.push_back(match(query, pattern));
        }
        return res;
    }
};