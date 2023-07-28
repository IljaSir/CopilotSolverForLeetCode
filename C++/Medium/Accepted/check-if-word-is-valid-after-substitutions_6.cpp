class Solution {
public:
    bool isValid(string s) {
        
        string t = "";
        for (auto c : s) {
            t.push_back(c);
            int n = t.size();
            if (n >= 3 && t[n-1] == 'c' && t[n-2] == 'b' && t[n-3] == 'a') {
                t.pop_back();
                t.pop_back();
                t.pop_back();
            }
        }
        return t.empty();
    }
};