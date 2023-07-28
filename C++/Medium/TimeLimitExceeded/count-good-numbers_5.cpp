class Solution {
public:
    int countGoodNumbers(long long n) {
        
        long long mod = 1000000007;
        long long ans = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ans = ans * 5 % mod;
            } else {
                ans = ans * 4 % mod;
            }
        }
        return (int)ans;
    }
};