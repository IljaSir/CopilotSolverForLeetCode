class Solution {
public:
    string getHappyString(int n, int k) {
        
        string res = "";
        vector<string> s = {"a", "b", "c"};
        vector<string> t = {};
        for (int i = 1; i < n; i++) {
            for (auto &e : s) {
                for (auto &c : "abc") {
                    if (e.back() != c) {
                        t.push_back(e + c);
                    }
                }
            }
            s = t;
            t.clear();
        }
        if (k > s.size()) {
            return res;
        }
        return s[k - 1];
    }
};