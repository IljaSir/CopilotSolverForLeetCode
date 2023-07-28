class Solution {
    public int alternateDigitSum(int n) {
        
        int res = 0;
        boolean isPositive = true;
        while (n > 0) {
            if (isPositive) {
                res += n % 10;
            } else {
                res -= n % 10;
            }
            n /= 10;
            isPositive = !isPositive;
        }
        return res;
    }
}