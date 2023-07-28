class Solution {
public:
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        
        vector<bool> res;
        for (auto &q: queries) {
            int i = 0;
            for (auto &c: q) {
                if (i < pattern.size() && c == pattern[i]) {
                    i++;
                } else if (c >= 'A' && c <= 'Z') {
                    res.push_back(false);
                    goto next;
                }
            }
            res.push_back(i == pattern.size());
        next:;
        }
        return res;
    }
};