class Solution {
public:
    string sortSentence(string s) {
        
        int n = s.length();
        if (n == 0) return "";
        string res = "";
        unordered_map<int, string> m;
        for (int i = 0; i < n; i++) {
            string tmp = "";
            while (i < n && s[i] != ' ') {
                tmp += s[i++];
            }
            m[tmp.back() - '0'] = tmp.substr(0, tmp.length() - 1);
        }
        for (int i = 1; i <= m.size(); i++) {
            res += m[i] + " ";
        }
        res.pop_back();
        return res;
    }
};