class Solution {
public:
    string addStrings(string num1, string num2) {
        
        string result;
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1[i] - '0';
                --i;
            }
            if (j >= 0) {
                sum += num2[j] - '0';
                --j;
            }
            result += to_string(sum % 10);
            carry = sum / 10;
        }
        if (carry) {
            result += to_string(carry);
        }
        reverse(result.begin(), result.end());
        return result;
    }
};