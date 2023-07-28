class Solution {
public:
    bool isAdditiveNumber(string num) {
        
        int n = num.size();
        for (int i = 1; i <= n / 2; ++i) {
            for (int j = 1; j <= (n - i) / 2; ++j) {
                if (check(num.substr(0, i), num.substr(i, j), num.substr(i + j))) {
                    return true;
                }
            }
        }
        return false;
    }
    bool check(string num1, string num2, string num) {
        if (num1.size() > 1 && num1[0] == '0' || num2.size() > 1 && num2[0] == '0') {
            return false;
        }
        string sum = add(num1, num2);
        if (sum == num) {
            return true;
        }
        if (num.size() <= sum.size() || sum.compare(num.substr(0, sum.size())) != 0) {
            return false;
        }
        return check(num2, sum, num.substr(sum.size()));
    }
    string add(string num1, string num2) {
        string sum;
        int carry = 0, n1 = num1.size() - 1, n2 = num2.size() - 1;
        while (n1 >= 0 || n2 >= 0) {
            int x1 = n1 >= 0 ? num1[n1--] - '0' : 0;
            int x2 = n2 >= 0 ? num2[n2--] - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            sum.push_back(value + '0');
        }
        if (carry != 0) {
            sum.push_back(carry + '0');
        }
        reverse(sum.begin(), sum.end());
        return sum;
    }
};