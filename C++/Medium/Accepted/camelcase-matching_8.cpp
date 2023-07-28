class Solution {
public:
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        
        vector<bool> result;
        for (auto &s : queries) {
            result.push_back(match(s, pattern));
        }
        return result;
    }
    bool match(string &s, string &p) {
        int i = 0;
        for (auto &c : s) {
            if (i < p.size() && c == p[i]) {
                ++i;
            } else if (c >= 'A' && c <= 'Z') {
                return false;
            }
        }
        return i == p.size();
    }
};