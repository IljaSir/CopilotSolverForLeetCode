class Solution {
public:
    int alternateDigitSum(int n) {
        
        int i = 1, sum = 0, rem;
        while (n) {
            rem = n % 10;
            if (i % 2 == 0) {
                sum -= rem;
            } else {
                sum += rem;
            }
            i++;
            n /= 10;
        }
        return sum;
    }
};