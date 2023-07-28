class Solution {
public:
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        
        vector<bool> res;
        for (auto &s : queries) {
            int i = 0;
            for (auto c : s) {
                if (i < pattern.size() && c == pattern[i]) {
                    i++;
                } else if (isupper(c)) {
                    i = -1;
                    break;
                }
            }
            res.push_back(i == pattern.size());
        }
        return res;
    }
};