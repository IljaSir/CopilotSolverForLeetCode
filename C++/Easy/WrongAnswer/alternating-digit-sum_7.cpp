class Solution {
public:
    int alternateDigitSum(int n) {
        
        int sum = 0;
        int pos = 1;
        while (n) {
            int digit = n % 10;
            sum += pos * digit;
            pos *= -1;
            n /= 10;
        }
        return sum;
    }
};