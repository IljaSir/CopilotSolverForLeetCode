class Solution {
public:
    int alternateDigitSum(int n) {
        
        int sum = 0;
        bool positive = true;
        while (n > 0) {
            if (positive) {
                sum += n % 10;
            } else {
                sum -= n % 10;
            }
            positive = !positive;
            n /= 10;
        }
        return sum;
    }
};