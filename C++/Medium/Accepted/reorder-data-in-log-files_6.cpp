class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        
        vector<string> result;
        vector<string> digitLogs;
        vector<string> letterLogs;
        for (auto& log : logs) {
            if (log[log.find(' ') + 1] >= '0' && log[log.find(' ') + 1] <= '9') {
                digitLogs.push_back(log);
            } else {
                letterLogs.push_back(log);
            }
        }
        sort(letterLogs.begin(), letterLogs.end(), [](const string& a, const string& b) {
            string aContent = a.substr(a.find(' ') + 1);
            string bContent = b.substr(b.find(' ') + 1);
            if (aContent == bContent) {
                return a.substr(0, a.find(' ')) < b.substr(0, b.find(' '));
            }
            return aContent < bContent;
        });
        result.insert(result.end(), letterLogs.begin(), letterLogs.end());
        result.insert(result.end(), digitLogs.begin(), digitLogs.end());
        return result;
    }
};