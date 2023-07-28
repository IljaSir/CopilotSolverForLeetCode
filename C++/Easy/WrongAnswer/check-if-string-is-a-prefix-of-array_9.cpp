class Solution {
public:
    bool isPrefixString(string s, vector<string>& words) {
        
        unsigned int i = 0;
        for (auto& w : words) {
            for (auto& c : w) {
                if (i >= s.size()) return false;
                if (s[i] != c) return false;
                ++i;
            }
        }
        return i == s.size();
    }
};