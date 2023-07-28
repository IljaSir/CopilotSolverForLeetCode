class Solution {
public:
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        
        string s = to_string(n);
        int len = s.length();
        int ret = 0;
        for (int i = 1; i < len; i++) {
            ret += pow(digits.size(), i);
        }
        for (int i = 0; i < len; i++) {
            bool flag = false;
            for (string& digit : digits) {
                if (digit[0] < s[i]) {
                    ret += pow(digits.size(), len - i - 1);
                } else if (digit[0] == s[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return ret;
            }
        }
        return ret + 1;
    }
};