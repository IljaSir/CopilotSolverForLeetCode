class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        
        vector<string> result;
        vector<string> digitLogs;
        vector<string> letterLogs;
        for (int i = 0; i < logs.size(); i++) {
            if (isdigit(logs[i][logs[i].size() - 1])) {
                digitLogs.push_back(logs[i]);
            } else {
                letterLogs.push_back(logs[i]);
            }
        }
        sort(letterLogs.begin(), letterLogs.end(), [](string a, string b) {
            int aSpace = a.find(" ");
            int bSpace = b.find(" ");
            string aContent = a.substr(aSpace + 1);
            string bContent = b.substr(bSpace + 1);
            if (aContent == bContent) {
                return a.substr(0, aSpace) < b.substr(0, bSpace);
            } else {
                return aContent < bContent;
            }
        });
        for (int i = 0; i < letterLogs.size(); i++) {
            result.push_back(letterLogs[i]);
        }
        for (int i = 0; i < digitLogs.size(); i++) {
            result.push_back(digitLogs[i]);
        }
        return result;
    }
};