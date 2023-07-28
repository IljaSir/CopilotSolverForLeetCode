class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        
        unordered_map<string, string> m;
        for (auto& v : knowledge) {
            m[v[0]] = v[1];
        }
        string res = "";
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                int j = i + 1;
                while (j < s.size() && s[j] != ')') j++;
                if (j < s.size()) {
                    string k = s.substr(i + 1, j - i - 1);
                    if (m.find(k) != m.end()) {
                        res += m[k];
                    } else {
                        res += "?";
                    }
                    i = j;
                } else {
                    res += "?";
                }
            } else {
                res += s[i];
            }
        }
        return res;
    }
};