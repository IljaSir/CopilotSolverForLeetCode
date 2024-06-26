class Solution {
public:
    string makeGood(string s) {
        
        int n = s.size();
        string res;
        for (int i = 0; i < n; ++i) {
            if (res.size() && abs(s[i] - res.back()) == 32) {
                res.pop_back();
            } else {
                res.push_back(s[i]);
            }
        }
        return res;
    }
};