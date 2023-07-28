class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        
        unordered_map<string, string> map;
        for (auto &v: knowledge) {
            map[v[0]] = v[1];
        }
        string ans;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] == '(') {
                int j = i + 1;
                while (j < s.size() && s[j] != ')') ++j;
                string key = s.substr(i + 1, j - i - 1);
                if (map.find(key) != map.end()) {
                    ans += map[key];
                } else {
                    ans += '?';
                }
                i = j;
            } else {
                ans += s[i];
            }
        }
        return ans;
    }
};