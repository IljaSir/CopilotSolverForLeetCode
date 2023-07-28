class Solution {
public:
    string addStrings(string num1, string num2) {
        
        int n = num1.size();
        int m = num2.size();
        int carry = 0;
        string ans = "";
        for (int i = n - 1, j = m - 1; i >= 0 || j >= 0 || carry; i--, j--) {
            int sum = 0;
            if (i >= 0) {
                sum += (num1[i] - '0');
            }
            if (j >= 0) {
                sum += (num2[j] - '0');
            }
            sum += carry;
            ans += to_string(sum % 10);
            carry = sum / 10;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};