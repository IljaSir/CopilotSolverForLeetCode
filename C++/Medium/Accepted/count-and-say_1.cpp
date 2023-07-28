class Solution {
public:
    string countAndSay(int n) {
        
        if (n == 1) return "1";
        string s = countAndSay(n - 1);
        string res;
        int count = 1;
        char c = s[0];
        for (int i = 1; i < s.size(); i++) {
            if (s[i] == c) {
                count++;
            } else {
                res += to_string(count) + c;
                count = 1;
                c = s[i];
            }
        }
        res += to_string(count) + c;
        return res;
    }
};