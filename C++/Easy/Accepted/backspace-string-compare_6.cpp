class Solution {
public:
    bool backspaceCompare(string s, string t) {
        
        return build(s) == build(t);
    }
    
    string build(string s) {
        string res;
        for (char c : s) {
            if (c != '#') res.push_back(c);
            else if (!res.empty()) res.pop_back();
        }
        return res;
    }
};