class Solution {
public:
    vector<string> removeComments(vector<string>& source) {
        
        vector<string> result;
        string line;
        bool inBlock = false;
        for (string& s : source) {
            for (int i = 0; i < s.length(); ++i) {
                if (!inBlock && s[i] == '/' && i < s.length() - 1 && s[i + 1] == '/') {
                    break;
                } else if (!inBlock && s[i] == '/' && i < s.length() - 1 && s[i + 1] == '*') {
                    inBlock = true;
                    ++i;
                } else if (inBlock && s[i] == '*' && i < s.length() - 1 && s[i + 1] == '/') {
                    inBlock = false;
                    ++i;
                } else if (!inBlock) {
                    line += s[i];
                }
            }
            if (!inBlock && line.length() > 0) {
                result.push_back(line);
                line = "";
            }
        }
        return result;
    }
};