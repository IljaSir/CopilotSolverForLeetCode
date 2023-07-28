class Solution {
public:
    vector<string> removeComments(vector<string>& source) {
        
        vector<string> result;
        string line;
        bool comment = false;
        for (string s : source) {
            for (int i = 0; i < s.size(); i++) {
                if (!comment && i < s.size() - 1 && s[i] == '/' && s[i+1] == '/') {
                    break;
                } else if (!comment && i < s.size() - 1 && s[i] == '/' && s[i+1] == '*') {
                    comment = true;
                    i++;
                } else if (comment && i < s.size() - 1 && s[i] == '*' && s[i+1] == '/') {
                    comment = false;
                    i++;
                } else if (!comment) {
                    line += s[i];
                }
            }
            if (!comment && line.size() > 0) {
                result.push_back(line);
                line = "";
            }
        }
        return result;
    }
};