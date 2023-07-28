class Solution {
public:
    int monkeyMove(int n) {
        
        int mod = 1e9 + 7;
        long long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = (ans * 2) % mod;
        }
        return (ans - n - 1) % mod;
    }
};