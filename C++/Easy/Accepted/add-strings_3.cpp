class Solution {
public:
    string addStrings(string num1, string num2) {
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        string ans = "";
        while (i >= 0 || j >= 0 || carry != 0) {
            int a = i >= 0 ? num1[i--] - '0' : 0;
            int b = j >= 0 ? num2[j--] - '0' : 0;
            int sum = a + b + carry;
            ans = to_string(sum % 10) + ans;
            carry = sum / 10;
        }
        return ans;
    }
};