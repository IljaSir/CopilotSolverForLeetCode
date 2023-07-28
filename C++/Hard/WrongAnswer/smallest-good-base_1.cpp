class Solution {
public:
    string smallestGoodBase(string n) {
        
        long long num = stoll(n);
        int max_len = log(num) / log(2);
        for (int len = max_len; len > 1; len--) {
            long long base = pow(num, 1.0 / (len - 1));
            long long sum = 1;
            long long cur = 1;
            for (int i = 1; i < len; i++) {
                cur *= base;
                sum += cur;
            }
            if (sum == num) {
                return to_string(base);
            }
        }
        return to_string(num - 1);
    }
};