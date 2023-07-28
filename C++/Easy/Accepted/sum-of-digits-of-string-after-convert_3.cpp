class Solution {
public:
    int getLucky(string s, int k) {
        
        string num = "";
        for (auto c : s) {
            num += to_string(c - 'a' + 1);
        }
        int res = 0;
        while (k--) {
            res = 0;
            for (auto c : num) {
                res += c - '0';
            }
            num = to_string(res);
        }
        return res;
    }
};