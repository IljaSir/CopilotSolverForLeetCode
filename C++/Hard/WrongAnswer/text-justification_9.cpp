class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        
        vector<string> res;
        string s = "";
        int len = 0;
        for (int i = 0; i < words.size(); i++) {
            if (len + words[i].size() + s.size() <= maxWidth) {
                s += words[i];
                len += words[i].size();
            } else {
                res.push_back(justify(s, len, maxWidth));
                s = words[i];
                len = words[i].size();
            }
        }
        res.push_back(s);
        res[res.size() - 1] += string(maxWidth - res[res.size() - 1].size(), ' ');
        return res;
    }
    string justify(string s, int len, int maxWidth) {
        int n = s.size();
        if (n == 1) return s + string(maxWidth - len, ' ');
        int spaces = maxWidth - len;
        int space = spaces / (n - 1);
        int extra = spaces % (n - 1);
        string res = "";
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == ' ') {
                res += string(space, ' ');
                if (extra > 0) {
                    res += ' ';
                    extra--;
                }
            } else {
                res += s[i];
            }
        }
        return res;
    }
};