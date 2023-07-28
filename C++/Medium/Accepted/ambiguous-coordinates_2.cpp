class Solution {
public:
    vector<string> ambiguousCoordinates(string s) {
        
        vector<string> res;
        for (int i = 2; i < s.size() - 1; i++) {
            vector<string> left = make(s.substr(1, i - 1));
            vector<string> right = make(s.substr(i, s.size() - i - 1));
            for (auto l: left) {
                for (auto r: right) {
                    res.push_back("(" + l + ", " + r + ")");
                }
            }
        }
        return res;
    }
    vector<string> make(string s) {
        int n = s.size();
        vector<string> res;
        if (n == 0 || (n > 1 && s[0] == '0' && s[n - 1] == '0')) return res;
        if (n > 1 && s[0] == '0') {
            res.push_back("0." + s.substr(1));
            return res;
        }
        if (n == 1 || s[n - 1] == '0') {
            res.push_back(s);
            return res;
        }
        res.push_back(s);
        for (int i = 1; i < n; i++) {
            res.push_back(s.substr(0, i) + "." + s.substr(i));
        }
        return res;
    }
};