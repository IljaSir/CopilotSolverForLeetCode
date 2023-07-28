class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        
        vector<string> letterLogs;
        vector<string> digitLogs;
        for (string log : logs) {
            int index = log.find(' ');
            if (isdigit(log[index+1])) {
                digitLogs.push_back(log);
            } else {
                letterLogs.push_back(log);
            }
        }
        sort(letterLogs.begin(), letterLogs.end(), [](string& a, string& b) {
            int indexA = a.find(' ');
            int indexB = b.find(' ');
            string contentA = a.substr(indexA + 1);
            string contentB = b.substr(indexB + 1);
            if (contentA == contentB) {
                return a.substr(0, indexA) < b.substr(0, indexB);
            }
            return contentA < contentB;
        });
        letterLogs.insert(letterLogs.end(), digitLogs.begin(), digitLogs.end());
        return letterLogs;
    }
};