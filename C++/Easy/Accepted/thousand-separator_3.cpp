class Solution {
public:
    string thousandSeparator(int n) {
        
        string s = to_string(n);
        string res;
        for (int i = s.size() - 1, j = 0; i >= 0; i--, j++) {
            if (j == 3) {
                res += '.';
                j = 0;
            }
            res += s[i];
        }
        reverse(res.begin(), res.end());
        return res;
    }
};