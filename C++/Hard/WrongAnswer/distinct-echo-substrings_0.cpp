class Solution {
public:
    int distinctEchoSubstrings(string text) {
        
        int n = text.size();
        set<string> s;
        for (int i = 0; i < n; i++) {
            string t = "";
            for (int j = i; j < n; j++) {
                t += text[j];
                if (j - i + 1 > t.size()) continue;
                if (t.substr(0, j - i + 1) == t.substr(j - i + 1)) {
                    s.insert(t);
                }
            }
        }
        return s.size();
    }
};