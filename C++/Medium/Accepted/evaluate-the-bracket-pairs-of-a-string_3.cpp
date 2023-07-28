class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        
        unordered_map<string, string> mp;
        for (auto &v : knowledge) {
            mp[v[0]] = v[1];
        }
        string res;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                string key;
                while (s[++i] != ')') {
                    key += s[i];
                }
                res += mp.count(key) ? mp[key] : "?";
            } else {
                res += s[i];
            }
        }
        return res;
    }
};