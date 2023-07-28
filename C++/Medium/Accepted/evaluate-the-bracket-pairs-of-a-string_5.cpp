class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        
        unordered_map<string, string> kv;
        for (auto& item : knowledge) {
            kv[item[0]] = item[1];
        }
        string res;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                int j = i + 1;
                while (j < s.size() && s[j] != ')') {
                    j++;
                }
                string key = s.substr(i + 1, j - i - 1);
                if (kv.count(key)) {
                    res += kv[key];
                } else {
                    res += '?';
                }
                i = j;
            } else {
                res += s[i];
            }
        }
        return res;
    }
};