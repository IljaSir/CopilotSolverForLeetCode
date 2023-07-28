class Solution {
public:
    string makeGood(string s) {
        
        string t;
        for (auto c : s) {
            if (!t.empty() && abs(c - t.back()) == 32) {
                t.pop_back();
            } else {
                t.push_back(c);
            }
        }
        return t;
    }
};