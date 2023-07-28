class Solution {
public:
    string addStrings(string num1, string num2) {
        
        int carry = 0;
        string result;
        int i = num1.size() - 1, j = num2.size() - 1;
        while(i >= 0 || j >= 0 || carry > 0){
            int a = i >= 0 ? num1[i--] - '0' : 0;
            int b = j >= 0 ? num2[j--] - '0' : 0;
            int sum = a + b + carry;
            result += '0' + sum % 10;
            carry = sum / 10;
        }
        reverse(result.begin(), result.end());
        return result;
    }
};