class Solution {
public:
    string thousandSeparator(int n) {
        
        string s = to_string(n);
        string res;
        int i = 0;
        while (i < s.size()) {
            if (i % 3 == 0 && i != 0) {
                res += "." + s[i];
            } else {
                res += s[i];
            }
            i++;
        }
        return res;
    }
};