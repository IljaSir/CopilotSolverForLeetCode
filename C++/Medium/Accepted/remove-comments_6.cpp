class Solution {
public:
    vector<string> removeComments(vector<string>& source) {
        
        vector<string> res;
        bool inBlock = false;
        string newLine;
        for (string line : source) {
            int n = line.length();
            int i = 0;
            while (i < n) {
                if (!inBlock && i + 1 < n && line[i] == '/' && line[i + 1] == '/') {
                    break;
                } else if (!inBlock && i + 1 < n && line[i] == '/' && line[i + 1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i + 1 < n && line[i] == '*' && line[i + 1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock) {
                    newLine += line[i];
                }
                i++;
            }
            if (!inBlock && newLine.length() > 0) {
                res.push_back(newLine);
                newLine = "";
            }
        }
        return res;
    }
};