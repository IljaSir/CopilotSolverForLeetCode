class Solution {
public:
    string digitSum(string s, int k) {
        
        if (s.length() <= k) {
            int sum = 0;
            for (auto c: s) {
                sum += c - '0';
            }
            return to_string(sum);
        }
        string str;
        for (int i = 0; i < s.length(); i += k) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += s[j] - '0';
            }
            str += to_string(sum);
        }
        return digitSum(str, k);
    }
    string getLucky(string s, int k) {
        string str;
        for (auto c: s) {
            str += to_string(c - 'a' + 1);
        }
        return digitSum(str, k);
    }
};