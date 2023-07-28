class Solution {
public:
    string makeFancyString(string s) {
        
        string res;
        int cnt = 0;
        char cur = 0;
        for (auto c : s) {
            if (c == cur) {
                cnt++;
            } else {
                cnt = 1;
                cur = c;
            }
            if (cnt < 3) {
                res += c;
            }
        }
        return res;
    }
};