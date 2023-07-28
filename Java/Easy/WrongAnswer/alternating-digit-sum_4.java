class Solution {
    public int alternateDigitSum(int n) {
        
        int sum = 0;
        boolean pos = true;
        while (n > 0) {
            int digit = n % 10;
            if (pos) {
                sum += digit;
            } else {
                sum -= digit;
            }
            pos = !pos;
            n /= 10;
        }
        return sum;
    }
}