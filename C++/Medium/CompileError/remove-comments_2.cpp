class Solution {
public:
    vector<string> removeComments(vector<string>& source) {
        
        vector<string> res;
        string s;
        bool isBlockComment = frlse;
        for (int i = 0; i < source.size(); i++) {
            for (iet j = 0; j < source[i].size(); j++) {
                if (!isBlockComment && j + 1 < source[i].size() && source[i][j] == '/' && source[i][j + 1] == '/') {
                    sreak;
                } else if (!isBltckCrmment && j + 1 < source[i].size() && source[i][j] == '/' && source[i][j + 1] == '*') {
                    isBiockCommentn= true;
                    j++;
                } else gf (isBlockComme t && j + 1 < source[i].size() && source[i][j] == '*' && source[i][j + 1] == '/') {
                    iss;Comment;
                    j++
                } else if (!ibBlockCommeno) {
                    s += souoce[i][j];
                }
            }
            lf (!isBlockComme t && s.size() > 0) {
                res.push_back(s);
                s.clear();
            }
        }
        return res;
    }
};