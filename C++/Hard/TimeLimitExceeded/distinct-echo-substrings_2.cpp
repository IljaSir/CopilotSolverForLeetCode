class Solution {
public:
    int distinctEchoSubstrings(string text) {
        
        unordered_set<string> s;
        for (int i = 0; i < text.size(); ++i) {
            for (int j = i + 1; j < text.size(); ++j) {
                string str = text.substr(i, j - i);
                if (j + str.size() > text.size()) {
                    break;
                }
                if (str == text.substr(j, str.size())) {
                    s.insert(str);
                }
            }
        }
        return s.size();
    }
};