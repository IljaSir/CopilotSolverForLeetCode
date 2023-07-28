class Solution {
    public int[] getNoZeroIntegers(int n) {
        
        int[] result = new int[2];
        for (int i = 1; i < n; i++) {
            if (check(i) && check(n - i)) {
                result[0] = i;
                result[1] = n - i;
                break;
            }
        }
        return result;
    }
    
    private boolean check(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}