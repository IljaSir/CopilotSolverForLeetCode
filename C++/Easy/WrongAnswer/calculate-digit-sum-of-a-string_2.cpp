class Solution {
public:
    string digitSum(string s, int k) {
        
        int n = s.size();
        if (k >= n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (s[i] - '0');
            }
            return to_string(sum);
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += (s[i] - '0');
        }
        string str = to_string(sum);
        for (int i = k; i < n; i++) {
            sum -= (s[i - k] - '0');
            sum += (s[i] - '0');
            str += to_string(sum);
        }
        return str;
    }
    string calculate(string s, int k) {
        int n = s.size();
        if (k >= n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (s[i] - '0');
            }
            return to_string(sum);
        }
        string str = digitSum(s, k);
        while (str.size() > k) {
            str = digitSum(str, k);
        }
        return str;
    }
    string removeKdigits(string num, int k) {
        int n = num.size();
        if (k >= n) {
            return "0";
        }
        string str = calculate(num, k);
        int i = 0;
        while (i < str.size() && str[i] == '0') {
            i++;
        }
        if (i == str.size()) {
            return "0";
        }
        return str.substr(i);
    }
};