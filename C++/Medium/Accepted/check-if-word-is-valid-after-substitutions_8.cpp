class Solution {
public:
    bool isValid(string s) {
        
        if (s.empty()) return true;
        if (s.size() < 3) return false;
        string t;
        for (auto ch : s) {
            t.push_back(ch);
            if (t.size() >= 3 && t[t.size() - 3] == 'a' && t[t.size() - 2] == 'b' && t[t.size() - 1] == 'c') {
                t.pop_back();
                t.pop_back();
                t.pop_back();
            }
        }
        return t.empty();
    }
};