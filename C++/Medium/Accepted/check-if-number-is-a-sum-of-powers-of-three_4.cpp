class Solution {
public:
    bool checkPowersOfThree(int n) {
        
        int num = 1;
        while (num < n) {
            num *= 3;
        }
        while (num > 0) {
            if (num <= n) {
                n -= num;
            }
            num /= 3;
        }
        return n == 0;
    }
};