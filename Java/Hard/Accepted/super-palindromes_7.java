class Solution {
    public int superpalindromesInRange(String left, String right) {
        
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        long ans = 0;
        for (long i = 1; i <= 100000; i++) {
            String s = Long.toString(i);
            for (int j = s.length() - 2; j >= 0; j--) {
                s += s.charAt(j);
            }
            long n = Long.parseLong(s);
            long square = n * n;
            if (square > r) {
                break;
            }
            if (square >= l && isPalindrome(square)) {
                ans++;
            }
        }
        for (long i = 1; i <= 100000; i++) {
            String s = Long.toString(i);
            for (int j = s.length() - 1; j >= 0; j--) {
                s += s.charAt(j);
            }
            long n = Long.parseLong(s);
            long square = n * n;
            if (square > r) {
                break;
            }
            if (square >= l && isPalindrome(square)) {
                ans++;
            }
        }
        return (int) ans;
    }

    public boolean isPalindrome(long n) {
        String s = Long.toString(n);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}