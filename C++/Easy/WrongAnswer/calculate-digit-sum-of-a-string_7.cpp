class Solution {
public:
    string digitSum(string s, int k) {
        
        string res = "";
        int i = 0;
        while (i < s.length()) {
            int sum = 0;
            int j = 0;
            while (j < k && i < s.length()) {
                sum += s[i++] - '0';
                ++j;
            }
            res += to_string(sum);
        }
        return res;
    }
    string getLucky(string s, int k) {
        string t = "";
        for (char c : s) {
            t += to_string(c - 'a' + 1);
        }
        while (k--) {
            t = digitSum(t, t.length());
        }
        return t;
    }
};