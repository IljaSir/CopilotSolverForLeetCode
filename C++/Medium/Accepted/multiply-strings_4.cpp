class Solution {
public:
    string multiply(string num1, string num2) {
        
        if (num1 == "0" || num2 == "0") return "0";
        int n = num1.size(), m = num2.size();
        string res(n + m, '0');
        for (int i = n - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = m - 1; j >= 0; j--) {
                int tmp = (num1[i] - '0') * (num2[j] - '0') + carry + (res[i + j + 1] - '0');
                res[i + j + 1] = tmp % 10 + '0';
                carry = tmp / 10;
            }
            res[i] += carry;
        }
        size_t startpos = res.find_first_not_of("0");
        if (string::npos != startpos) {
            return res.substr(startpos);
        }
        return "0";
    }
};