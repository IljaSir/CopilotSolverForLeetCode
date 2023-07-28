class Solution {
    public int largestPalindrome(int n) {
        
        if (n == 1) {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int lower = upper / 10;
        for (int i = upper; i > lower; i--) {
            long palindrome = createPalindrome(i);
            for (long j = upper; j * j >= palindrome; j--) {
                if (palindrome % j == 0) {
                    return (int) (palindrome % 1337);
                }
            }
        }
        return -1;
    }
}