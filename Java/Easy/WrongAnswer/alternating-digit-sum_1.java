class Solution {
    public int alternateDigitSum(int n) {
        
        int sum = 0;
        int sign = 1;
        while (n > 0) {
            sum += sign * (n % 10);
            n /= 10;
            sign *= -1;
        }
        return sum;
    }
}