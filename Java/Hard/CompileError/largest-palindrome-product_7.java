class Solution {
    public int largestPalindrome(int n) {
        
        if (n == 1) return 9;
        int upper = (int) Math.pow(10, n) - 1;
        int lower = (int) Math.pow(10, n - 1);
        for (int i = upper; i >= lower; i--) {
            long pal = getPalindrome(i);
            for (long j = upper; j * j >= pal; j--) {
                if (pal % j == 0) return (int) (pal % 1337);
            }
        }
        return -1;
    }
}