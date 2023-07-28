class Solution {
public:
    string multiply(string num1, string num2) {
        
        int n1 = num1.size(), n2 = num2.size();
        string ans(n1 + n2, '0');
        for (int i = n1 - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = n2 - 1; j >= 0; j--) {
                int sum = (num1[i] - '0') * (num2[j] - '0') + carry + (ans[i + j + 1] - '0');
                carry = sum / 10;
                ans[i + j + 1] = sum % 10 + '0';
            }
            ans[i] += carry;
        }
        size_t startpos = ans.find_first_not_of("0");
        if (string::npos != startpos) {
            return ans.substr(startpos);
        }
        return "0";
    }
};