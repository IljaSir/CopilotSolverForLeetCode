class Solution {
public:
    int alternateDigitSum(int n) {
        
        int sum = 0;
        bool sign = true;
        while(n) {
            int digit = n % 10;
            if (sign) sum += digit;
            else sum -= digit;
            sign = !sign;
            n /= 10;
        }
        return sum;
    }
};