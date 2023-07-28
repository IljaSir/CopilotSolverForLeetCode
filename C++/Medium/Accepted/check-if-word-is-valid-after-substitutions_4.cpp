class Solution {
public:
    bool isValid(string s) {
        
        string t;
        for (char c : s) {
            t += c;
            if (t.size() >= 3 && t.substr(t.size() - 3) == "abc") t.resize(t.size() - 3);
        }
        return t.empty();
    }
};