class Solution {
public:
    string smallestGoodBase(string n) {
        
        long long num = stoll(n);
        long long ans = num - 1;
        for (int m = log(num) / log(2); m >= 2; m--) {
            long long k = pow(num, 1.0 / (m - 1));
            long long mul = 1, sum = 1;
            for (int i = 1; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == num) {
                ans = k;
                break;
            }
        }
        return to_string(ans);
    }
};