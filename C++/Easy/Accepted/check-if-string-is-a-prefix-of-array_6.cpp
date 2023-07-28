class Solution {
public:
    bool isPrefixString(string s, vector<string>& words) {
        
        int i = 0;
        for (auto &word: words) {
            for (auto &c: word) {
                if (i >= s.size() || c != s[i]) {
                    return false;
                }
                i++;
            }
            if (i >= s.size()) {
                return true;
            }
        }
        return false;
    }
};