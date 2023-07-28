class Solution {
public:
    bool isValid(string s) {
        
        string t;
        for (int i = 0; i < s.size(); ++i) {
            t += s[i];
            if (t.size() >= 3 && t.substr(t.size() - 3) == "abc") {
                t.resize(t.size() - 3);
            }
        }
        return t.empty();
    }
};