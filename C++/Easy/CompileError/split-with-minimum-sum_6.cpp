class Solution {
public:
    int splitNum(int num) {
        
        int sum = 0;
        while (num) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    int split(int num, int i, int sum, int sum1, int sum2, vector<int> &digits) {
        if (i == 10) {
            return sum1 + sum2;
        }
        if (digits[i] == 0) {
            return split(num, i + 1, sum, sum1, sum2, digits);
        }
        if (sum1 + sum2 == sum) {
            return split(num, i + 1, sum, sum1, sum2, digits);
        }
        if (sum1 + sum2 > sum) {
            return 2 * sum;
        }
        int res = 2 * sum;
        int cnt = digits[i];
        for (int j = 0; j <= cnt; j++) {
            digits[i] -= j;
            res = min(res, split(num, i + 1, sum, sum1 + j * i, sum2 + (cnt - j) * i, digits));
            digits[i] += j;
        }
        return res;
    }
    int splitNum(string &num) {
        int sum = 0;
        for (int i = 0; i < num.size(); i++) {
            sum += num[i] - '0';
        }
        return sum;
    }
    int split(string &num, int i, int sum, int sum1, int sum2, vector<int> &digits) {
        if (i == num.size()) {
            return sum1 + sum2;
        }
        if (digits[num[i] - '0'] == 0) {
            return split(num, i + 1, sum, sum1, sum2, digits);
        }
        if (sum1 + sum2 == sum) {
            return split(num, i + 1, sum, sum1, sum2, digits);
        }
        if (sum1 + sum2 > sum) {
            return 2 * sum;
        }
        int res = 2 * sum;
        int cnt = digits[num[i] - '0'];
        for (int j = 0; j <= cnt; j++) {
            digits[num[i] - '0'] -= j;
    }
};