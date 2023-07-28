class Solution {
public:
    string repeatLimitedString(string s, int repeatLimit) {
        
        int n = s.size();
        vector<int> cnt(26);
        for (auto c: s) ++cnt[c-'a'];
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > repeatLimit) return "";
        }
        string res;
        for (int i = 0; i < n; ++i) {
            if (res.empty()) {
                res.push_back(s[i]);
            } else {
                if (s[i] == res.back()) {
                    if (res.size() >= repeatLimit) {
                        continue;
                    } else {
                        res.push_back(s[i]);
                    }
                } else {
                    res.push_back(s[i]);
                }
            }
        }
        return res;
    }
};