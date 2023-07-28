class Solution {
public:
    bool checkPowersOfThree(int n) {
        
        int x = 1;
        while (x <= n) {
            x *= 3;
        }
        while (x > 1) {
            x /= 3;
            if (n >= x) {
                n -= x;
            }
        }
        return n == 0;
    }
};