class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        
        unordered_map<string, int> m;
        for (auto &c : s1) {
            if (c == ' ') {
                c = '\0';
            }
        }
        for (auto &c : s2) {
            if (c == ' ') {
                c = '\0';
            }
        }
        for (auto p = s1.c_str(); p < s1.c_str() + s1.size(); p += strlen(p) + 1) {
            m[string(p)]++;
        }
        for (auto p = s2.c_str(); p < s2.c_str() + s2.size(); p += strlen(p) + 1) {
            m[string(p)]++;
        }
        vector<string> res;
        for (auto &p : m) {
            if (p.second == 1) {
                res.push_back(p.first);
            }
        }
        return res;
    }
};