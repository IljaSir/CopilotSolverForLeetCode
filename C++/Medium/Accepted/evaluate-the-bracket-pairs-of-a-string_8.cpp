class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        
        unordered_map<string, string> kv;
        for (auto& k: knowledge) {
            kv[k[0]] = k[1];
        }
        string ans;
        int i = 0;
        while (i < s.size()) {
            if (s[i] == '(') {
                int j = i + 1;
                while (s[j] != ')') ++j;
                string k = s.substr(i + 1, j - i - 1);
                if (kv.count(k)) {
                    ans += kv[k];
                } else {
                    ans += '?';
                }
                i = j + 1;
            } else {
                ans += s[i];
                ++i;
            }
        }
        return ans;
    }
};