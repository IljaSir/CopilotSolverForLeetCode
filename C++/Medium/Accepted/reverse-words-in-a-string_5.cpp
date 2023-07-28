class Solution {
public:
    string reverseWords(string s) {
        
        int n = s.length();
        string res;
        int i = n-1;
        while (i >= 0) {
            while (i >= 0 && s[i] == ' ') {
                i--;
            }
            if (i < 0) {
                break;
            }
            if (!res.empty()) {
                res.push_back(' ');
            }
            string t;
            while (i >= 0 && s[i] != ' ') {
                t.push_back(s[i--]);
            }
            reverse(t.begin(), t.end());
            res.append(t);
        }
        return res;
    }
};