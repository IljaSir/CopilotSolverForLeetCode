class Solution {
public:
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        
        vector<bool> result;
        for (auto& query : queries) {
            int j = 0;
            bool match = true;
            for (auto& ch : query) {
                if (j < pattern.size() && ch == pattern[j]) {
                    j++;
                } else if (isupper(ch)) {
                    match = false;
                    break;
                }
            }
            result.push_back(match && j == pattern.size());
        }
        return result;
    }
};