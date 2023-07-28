class Solution {
public:
    string countAndSay(int n) {
        
        if (n == 1) {
            return "1";
        }
        string s = countAndSay(n - 1);
        string res;
        int len = s.size();
        for (int i = 0; i < len; ++i) {
            int cnt = 1;
            while (i + 1 < len && s[i] == s[i + 1]) {
                ++cnt;
                ++i;
            }
            res += to_string(cnt) + s[i];
        }
        return res;
    }
};