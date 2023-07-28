class Solution {
public:
    string thousandSeparator(int n) {
        
        string s = to_string(n);
        int len = s.length();
        if (len <= 3) return s;
        int i = len % 3;
        string res = s.substr(0, i);
        while (i < len) {
            if (res.length() > 0) res += ".";
            res += s.substr(i, 3);
            i += 3;
        }
        return res;
    }
};