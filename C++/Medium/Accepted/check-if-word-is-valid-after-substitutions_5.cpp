class Solution {
public:
    bool isValid(string s) {
        
        string t = "";
        for (char ch : s) {
            t += ch;
            if (t.length() >= 3) {
                if (t[t.length() - 1] == 'c' && t[t.length() - 2] == 'b' && t[t.length() - 3] == 'a') {
                    t = t.substr(0, t.length() - 3);
                }
            }
        }
        return t == "";
    }
};