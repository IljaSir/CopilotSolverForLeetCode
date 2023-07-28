class Solution {
    public int alternateDigitSum(int n) {
        
        int result = 0;
        boolean positive = true;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            if (positive) {
                result += digit;
                positive = false;
            } else {
                result -= digit;
                positive = true;
            }
        }
        return result;
    }
}