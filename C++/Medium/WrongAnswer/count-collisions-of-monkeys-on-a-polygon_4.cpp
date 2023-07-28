class Solution {
public:
    int monkeyMove(int n) {
        
        long long mod = 1e9 + 7;
        if (n % 2 == 0) {
            long long ans = 1;
            for (int i = 0; i < n / 2; i++) {
                ans = ans * 2 % mod;
            }
            return ans;
        }
        else {
            long long ans = 1;
            for (int i = 0; i < (n - 1) / 2; i++) {
                ans = ans * 2 % mod;
            }
            return ans * 2 % mod;
        }
    }
    int countCollisions(int n) {
        long long mod = 1e9 + 7;
        long long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += monkeyMove(i);
            ans %= mod;
        }
        return ans;
    }
};