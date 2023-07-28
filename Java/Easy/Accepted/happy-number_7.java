class Solution {
    public boolean isHappy(int n) {
        
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
            if (n == 0) {
                n = sum;
                sum = 0;
                if (n == 1) {
                    return true;
                }
                if (n == 4) {
                    return false;
                }
            }
        }
        return false;
    }
}