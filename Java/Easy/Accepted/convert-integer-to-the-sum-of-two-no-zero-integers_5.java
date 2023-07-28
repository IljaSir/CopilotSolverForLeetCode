class Solution {
    public int[] getNoZeroIntegers(int n) {
        
        for (int i = 1; i < n; i++) {
            if (check(i) && check(n - i)) {
                return new int[] {i, n - i};
            }
        }
        return new int[0];
    }
    private boolean check(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}