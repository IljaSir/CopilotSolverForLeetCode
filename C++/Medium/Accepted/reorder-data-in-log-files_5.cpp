class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        
        vector<string> result;
        vector<string> digitLogs;
        vector<string> letterLogs;
        for (string log : logs) {
            if (log[log.find(' ') + 1] >= '0' && log[log.find(' ') + 1] <= '9') {
                digitLogs.push_back(log);
            } else {
                letterLogs.push_back(log);
            }
        }
        sort(letterLogs.begin(), letterLogs.end(), [](const string& a, const string& b) {
            int aPos = a.find(' ');
            int bPos = b.find(' ');
            if (a.substr(aPos + 1) == b.substr(bPos + 1)) {
                return a.substr(0, aPos) < b.substr(0, bPos);
            }
            return a.substr(aPos + 1) < b.substr(bPos + 1);
        });
        result.insert(result.end(), letterLogs.begin(), letterLogs.end());
        result.insert(result.end(), digitLogs.begin(), digitLogs.end());
        return result;
    }
};