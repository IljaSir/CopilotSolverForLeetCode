class Solution {
public:
    string removeOccurrences(string s, string part) {
        
        string t;
        int i = 0, j = 0;
        while (i < s.size()) {
            t.push_back(s[i++]);
            if (t.size() >= part.size() && t.substr(t.size() - part.size()) == part) {
                t.erase(t.size() - part.size());
            }
        }
        return t;
    }
};