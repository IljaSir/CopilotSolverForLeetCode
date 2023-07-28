class Solution {
public:
    int monkeyMove(int n) {
        
        if (n == 3) return 6;
        if (n == 4) return 14;
        long long a = 6, b = 14;
        for (int i = 5; i <= n; ++i) {
            long long c = 2 * b + a;
            a = b;
            b = c;
        }
        return b % 1000000007;
    }
};