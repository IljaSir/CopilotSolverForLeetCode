class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        
        unordered_map<string, string> m;
        for (auto& kv : knowledge) {
            m[kv[0]] = kv[1];
        }
        string res;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == '(') {
                int j = i + 1;
                while (j < s.size() && s[j] != ')') {
                    ++j;
                }
                string key = s.substr(i + 1, j - i - 1);
                res += m.count(key) ? m[key] : "?";
                i = j;
            } else {
                res += s[i];
            }
        }
        return res;
    }
};