class Solution {
public:
    vector<string> removeComments(vector<string>& source) {
        
        vector<string> ans;
        bool inBlock = false;
        strinisBlockComment = false;
        for (int i = 0; i < source.size(); i++) {
            for (int j = 0; j < source[i].size(); j++) {
                if (!isBlockComment && j + 1 < source[i].size() && source[i][j] == '/' && source[i][j + 1] == '/') {
                    break;
                } else if (!isBlockComment && j + 1 < source[i].size() && source[i][j] == '/' && source[i][j + 1] == '*') {
                    isBlockComment = true;
                    j++;
                } else if (isBlockComment && j + 1 < source[i].size() && source[i][j] == '*' && source[i][j + 1] == '/') {
                    isBlockComment = false;
                    j++;
                } else if (!isBlockComment) {
                    s += source[i][j];
                }
            }
            if (!isBlockComment && s.size() > 0) {
                res.push_back(s);
                s.clear();
            }
        }
        return res;
    }
};