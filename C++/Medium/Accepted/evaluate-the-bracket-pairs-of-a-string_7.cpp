class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        
        unordered_map<string, string> map;
        for (auto &item : knowledge) {
            map[item[0]] = item[1];
        }
        string result;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == '(') {
                int j = i + 1;
                while (s[j] != ')') {
                    ++j;
                }
                string key = s.substr(i + 1, j - i - 1);
                if (map.find(key) != map.end()) {
                    result += map[key];
                } else {
                    result += '?';
                }
                i = j;
            } else {
                result += s[i];
            }
        }
        return result;
    }
};