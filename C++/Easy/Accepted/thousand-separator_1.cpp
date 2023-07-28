class Solution {
public:
    string thousandSeparator(int n) {
        
        string s = to_string(n);
        string res = "";
        int cnt = 0;
        for (int i = s.size() - 1; i >= 0; i--) {
            res += s[i];
            cnt++;
            if (cnt == 3 && i != 0) {
                res += '.';
                cnt = 0;
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};