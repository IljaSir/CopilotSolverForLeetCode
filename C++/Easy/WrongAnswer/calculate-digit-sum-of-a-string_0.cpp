class Solution {
public:
    string digitSum(string s, int k) {
        
        if (s.length() <= k) return s;
        string res = "";
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s[i] - '0';
            if ((i + 1) % k == 0) {
                res += (char) (sum + '0');
                sum = 0;
            }
        }
        if (sum > 0) res += (char) (sum + '0');
        return res;
    }
    string getLucky(string s, int k) {
        string res = "";
        for (int i = 0; i < s.length(); i++) {
            res += (char) ((s[i] - 'a' + 1) + '0');
        }
        for (int i = 0; i < k; i++) {
            res = digitSum(res, k);
        }
        return res;
    }
};