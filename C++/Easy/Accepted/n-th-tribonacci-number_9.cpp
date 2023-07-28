class Solution {
public:
    int tribonacci(int n) {
        
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        else {
            int x = 0, y = 1, z = 1;
            for (int i = 3; i <= n; ++i) {
                int t = x + y + z;
                x = y;
                y = z;
                z = t;
            }
            return z;
        }
    }
};