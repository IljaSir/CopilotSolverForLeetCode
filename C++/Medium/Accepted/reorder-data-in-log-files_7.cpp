class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        
        vector<string> ans;
        vector<string> digit;
        vector<pair<string, string>> letter;
        for (string log : logs) {
            int index = log.find(' ');
            if (isdigit(log[index + 1])) {
                digit.push_back(log);
            } else {
                letter.push_back({log.substr(0, index), log.substr(index + 1)});
            }
        }
        sort(letter.begin(), letter.end(), [](pair<string, string> a, pair<string, string> b) {
            return a.second == b.second ? a.first < b.first : a.second < b.second;
        });
        for (auto p : letter) {
            ans.push_back(p.first + ' ' + p.second);
        }
        for (string log : digit) {
            ans.push_back(log);
        }
        return ans;
    }
};