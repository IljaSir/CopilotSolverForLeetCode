class Solution {
public:
    string longestNiceSubstring(string s) {
        
        if (s.size() < 2) return "";
        unordered_set<char> set;
        for (auto ch : s) {
            set.insert(ch);
        }
        for (int i = 0; i < s.size(); ++i) {
            if (set.count(tolower(s[i])) && set.count(toupper(s[i]))) continue;
            auto left = longestNiceSubstring(s.substr(0, i));
            auto right = longestNiceSubstring(s.substr(i+1));
            return left.size() > right.size() ? left : right;
        }
        return s;
    }
};