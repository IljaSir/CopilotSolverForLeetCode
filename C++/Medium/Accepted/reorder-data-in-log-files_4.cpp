class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        
        vector<string> ans;
        vector<string> digit;
        vector<pair<string, string>> letter;
        for (int i = 0; i < logs.size(); i++) {
            int j = 0;
            while (j < logs[i].size() && logs[i][j] != ' ') j++;
            if (j == logs[i].size()) continue;
            if (isdigit(logs[i][j + 1])) {
                digit.push_back(logs[i]);
            } else {
                letter.push_back(make_pair(logs[i].substr(j + 1), logs[i].substr(0, j)));
            }
        }
        sort(letter.begin(), letter.end());
        for (int i = 0; i < letter.size(); i++) {
            ans.push_back(letter[i].second + " " + letter[i].first);
        }
        for (int i = 0; i < digit.size(); i++) {
            ans.push_back(digit[i]);
        }
        return ans;
    }
};