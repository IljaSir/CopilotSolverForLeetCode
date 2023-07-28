class Solution {
public:
    string thousandSeparator(int n) {
        
        string s = to_string(n);
        int l = s.length();
        if(l <= 3)
            return s;
        string res;
        int i = l % 3;
        if(i > 0)
            res += s.substr(0, i) + ".";
        while(i < l) {
            res += s.substr(i, 3) + ".";
            i += 3;
        }
        res.pop_back();
        return res;
    }
};