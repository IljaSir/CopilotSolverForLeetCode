class Solution {
public:
    vector<string> removeComments(vector<string>& source) {
        
        vector<string> ans;
        bool in_block = false;
        string new_line = "";
        for (string line : source) {
            for (int i = 0; i < line.size(); ++i) {
                if (in_block && line[i] == '*' && i + 1 < line.size() && line[i + 1] == '/') {
                    in_block = false;
                    ++i;
                } else if (!in_block && line[i] == '/' && i + 1 < line.size() && line[i + 1] == '*') {
                    in_block = true;
                    ++i;
                } else if (!in_block && line[i] == '/' && i + 1 < line.size() && line[i + 1] == '/') {
                    break;
                } else if (!in_block) {
                    new_line += line[i];
                }
            }
            if (!in_block && new_line.size() > 0) {
                ans.push_back(new_line);
                new_line = "";
            }
        }
        return ans;
    }
};