class Solution {
public:
    bool isPrefixString(string s, vector<string>& words) {
        
        string str;
        for (auto &word: words) {
            str += word;
            if (str == s) return true;
        }
        return false;
    }
};