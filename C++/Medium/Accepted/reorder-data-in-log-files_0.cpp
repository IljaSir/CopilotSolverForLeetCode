class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        
        vector<string> letterLogs;
        vector<string> digitLogs;
        for (int i = 0; i < logs.size(); i++) {
            if (logs[i][logs[i].size() - 1] >= '0' && logs[i][logs[i].size() - 1] <= '9') {
                digitLogs.push_back(logs[i]);
            } else {
                letterLogs.push_back(logs[i]);
            }
        }
        sort(letterLogs.begin(), letterLogs.end(), [](string& a, string& b) {
            int i = a.find(' ');
            int j = b.find(' ');
            if (a.substr(i + 1) == b.substr(j + 1)) {
                return a.substr(0, i) < b.substr(0, j);
            }
            return a.substr(i + 1) < b.substr(j + 1);
        });
        letterLogs.insert(letterLogs.end(), digitLogs.begin(), digitLogs.end());
        return letterLogs;
    }
};