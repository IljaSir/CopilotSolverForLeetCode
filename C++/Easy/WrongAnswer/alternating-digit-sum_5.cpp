class Solution {
public:
    int alternateDigitSum(int n) {
        
        int sum = 0;
        int sign = 1;
        while(n > 0) {
            int d = n % 10;
            sum += d * sign;
            sign = -sign;
            n /= 10;
        }
        return sum;
    }
};