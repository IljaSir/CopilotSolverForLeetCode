class Solution {
    public int superpalindromesInRange(String left, String right) {
        
        long leftLong = Long.parseLong(left);
        long rightLong = Long.parseLong(right);
        int count = 0;
        for (long i = 1; i <= 100000; i++) {
            String s = Long.toString(i);
            String sRev = new StringBuilder(s).reverse().toString();
            long p1 = Long.parseLong(s + sRev);
            long p2 = Long.parseLong(s + sRev.substring(1));
            if (p1 * p1 >= leftLong && p1 * p1 <= rightLong) {
                if (isPalindrome(p1 * p1)) {
                    count++;
                }
            }
            if (p2 * p2 >= leftLong && p2 * p2 <= rightLong) {
                if (isPalindrome(p2 * p2)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isPalindrome(long n) {
        String s = Long.toString(n);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}