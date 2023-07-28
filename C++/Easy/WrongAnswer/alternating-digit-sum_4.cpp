class Solution {
public:
    int alternateDigitSum(int n) {
        
        int sum = 0;
        while (n) {
            int d = n % 10;
            if (sum > 0)
                sum -= d;
            else
                sum += d;
            n /= 10;
        }
        return sum;
    }
};