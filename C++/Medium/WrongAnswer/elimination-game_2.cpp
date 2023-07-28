class Solution {
public:
    int lastRemaining(int n) {
        
        if (n == 1) return 1;
        int x = 2;
        while (x * 2 <= n) {
            x *= 2;
        }
        if (n == x) return x;
        int y = n - x;
        return y * 2;
    }
};