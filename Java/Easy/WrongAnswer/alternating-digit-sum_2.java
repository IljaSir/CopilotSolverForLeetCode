class Solution {
    public int alternateDigitSum(int n) {
        
        int sum = 0;
        boolean isPositive = true;
        while (n > 0) {
            int digit = n % 10;
            if (isPositive) {
                sum += digit;
            } else {
                sum -= digit;
            }
            n /= 10;
            isPositive = !isPositive;
        }
        return sum;
    }
}