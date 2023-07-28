class Solution {
    public int largestPalindrome(int n) {
        
        if (n == 1) {
            return 9;
        }
        int max = (int) Math.pow(10, n) - 1;
        int min = max / 10;
        for (int i = max; i > min; i--) {
            long palindrome = Long.parseLong(i + new StringBuilder().append(i).reverse().toString());
            for (long j = max; j * j > palindrome; j--) {
                if (palindrome % j == 0) {
                    return (int) (palindrome % 1337);
                }
            }
        }
        return 9;
    }
}