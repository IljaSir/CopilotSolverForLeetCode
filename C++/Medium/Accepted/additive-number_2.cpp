class Solution {
public:
    bool isAdditiveNumber(string num) {
        
        int n = num.size();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; n - i - j >= max(i, j); j++) {
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
        string ans;
        int n = num1.size() - 1, m = num2.size() - 1, carry = 0;
        while (n >= 0 || m >= 0 || carry != 0) {
            int x = n >= 0 ? num1[n--] - '0' : 0;
            int y = m >= 0 ? num2[m--] - '0' : 0;
            int result = x + y + carry;
            ans.push_back(result % 10 + '0');
            carry = result / 10;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};