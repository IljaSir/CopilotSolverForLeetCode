class Solution {
public:
    string digitSum(string s, int k) {
        
        string res = "";
        int n = s.length();
        for (int i = 0; i < n; i += k) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += s[j] - '0';
            }
            res += to_string(sum);
        }
        return res;
    }
    string removeLeadingZeros(string s) {
        int n = s.length();
        int i = 0;
        while (i < n && s[i] == '0') {
            i++;
        }
        if (i == n) {
            return "0";
        }
        return s.substr(i);
    }
    string calculateDigitSum(string s, int k) {
        string res = s;
        while (res.length() > k) {
            res = digitSum(res, k);
        }
        return removeLeadingZeros(res);
    }
};