class Solution {
public:
    vector<string> removeComments(vector<string>& source) {
        
        vector<string> res;
        bool inBlock = false;
        string out;
        for (string line : source) {
            for (int i = 0; i < line.size(); ++i) {
                if (!inBlock && i + 1 < line.size() && line[i] == '/' && line[i + 1] == '*') {
                    inBlock = true;
                    ++i;
                } else if (inBlock && i + 1 < line.size() && line[i] == '*' && line[i + 1] == '/') {
                    inBlock = false;
                    ++i;
                } else if (!inBlock && i + 1 < line.size() && line[i] == '/' && line[i + 1] == '/') {
                    break;
                } else if (!inBlock) {
                    out.push_back(line[i]);
                }
            }
            if (!inBlock && out.size() > 0) {
                res.push_back(out);
                out = "";
            }
        }
        return res;
    }
};