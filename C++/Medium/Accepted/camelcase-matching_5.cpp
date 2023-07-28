class Solution {
public:
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        
        vector<bool> result;
        for (auto& query: queries) {
            int i = 0;
            for (auto& c: query) {
                if (i < pattern.size() && c == pattern[i]) {
                    i++;
                } else if (isupper(c)) {
                    i = -1;
                    break;
                }
            }
            result.push_back(i == pattern.size());
        }
        return result;
    }
};