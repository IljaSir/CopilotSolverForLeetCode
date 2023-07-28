class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        
        vector<string> letterLogs;
        vector<string> digitLogs;
        for (auto log : logs) {
            int i = 0;
            while (log[i] != ' ') {
                i++;
            }
            if (log[i + 1] >= '0' && log[i + 1] <= '9') {
                digitLogs.push_back(log);
            } else {
                letterLogs.push_back(log);
            }
        }
        sort(letterLogs.begin(), letterLogs.end(), [](const string& a, const string& b) {
            int i = 0;
            while (a[i] != ' ') {
                i++;
            }
            string aContent = a.substr(i + 1, a.size() - i - 1);
            i = 0;
            while (b[i] != ' ') {
                i++;
            }
            string bContent = b.substr(i + 1, b.size() - i - 1);
            if (aContent == bContent) {
                return a < b;
            }
            return aContent < bContent;
        });
        for (auto log : digitLogs) {
            letterLogs.push_back(log);
        }
        return letterLogs;
    }
};