class Solution {
public:
    vector<string> removeComments(vector<string>& source) {
        
        vector<string> ans;
        bool inBlock = false;
        string newLine = "";
        for (string line: source) {
            int n = line.size();
            for (int i = 0; i < n; i++) {
                if (!inBlock && i + 1 < n && line[i] == '/' && line[i + 1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i + 1 < n && line[i] == '*' && line[i + 1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i + 1 < n && line[i] == '/' && line[i + 1] == '/') {
                    break;
                } else if (!inBlock) {
                    newLine += line[i];
                }
            }
            if (!inBlock && newLine.size() > 0) {
                ans.push_back(newLine);
                newLine = "";
            }
        }
        return ans;;
                s = "";
            }
        }
        return res;
    }
};