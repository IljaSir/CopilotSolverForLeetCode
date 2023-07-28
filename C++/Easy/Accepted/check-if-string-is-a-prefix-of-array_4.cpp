class Solution {
public:
    bool isPrefixString(string s, vector<string>& words) {
        
        string word;
        for (string w : words) {
            word += w;
            if (word == s) return true;
            if (word.size() > s.size()) return false;
        }
        return false;
    }
};