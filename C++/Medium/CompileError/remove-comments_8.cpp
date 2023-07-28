class Solution {
public:
    vector<string> removeComments(vector<string>& source) {
        
        vector<string> ans;
        string line;
        bool inComment = false;
        for (auto& s: source) {
            for (int i = 0; i < s.size(); ++i) {
                if (!inComment && i + 1 < s.size() && s[i] == '/' && s[i + 1] == '/') {
                    break;
                } else if (!inComment && i + 1 < s.size() && s[i] == '/' && s[i + 1] == '*') {
                    inComment = true;
                    ++i;
                } else if (inComment && i + 1 < s.size() && s[i] == '*' && s[i + 1] == '/') {
                    inComment = false;
                    ++i;
                } else if (!inComment) {
                    line.push_back(s[i]);
                }
            }
            if (!inComment && !line.empty()) {
                ans.push_back(line);
                line.clear();
            }
        }
        return ans
    }
};