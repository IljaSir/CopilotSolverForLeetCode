class Solution {
public:
    int distinctEchoSubstrings(string text) {
        
        int n = text.size(), ans = 0;
        unordered_set<string> s;
        for (int i = 0; i < n; ++i) {
            string t = "";
            for (int j = i; j < n; ++j) {
                t += text[j];
                if (j - i + 1 > t.size()) break;
                if (j - i + 1 == t.size() && t.substr(0, t.size() / 2) == t.substr(t.size() / 2)) {
                    if (s.find(t) == s.end()) {
                        s.insert(t);
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }
};