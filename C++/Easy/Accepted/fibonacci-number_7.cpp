class Solution {
public:
    int fib(int n) {
        
        int f = 0, g = 1;
        while (n--) {
            g = g + f;
            f = g - f;
        }
        return f;
    }
};