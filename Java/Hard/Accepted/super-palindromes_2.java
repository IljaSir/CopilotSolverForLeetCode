class Solution {
    public int superpalindromesInRange(String left, String right) {
        
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        int ans = 0;
        for (long i = 1; i <= 100000; i++) {
            String s = Long.toString(i);
            String t = new StringBuilder(s).reverse().toString();
            long v = Long.parseLong(s + t);
            v *= v;
            if (v > r) break;
            if (v >= l && isPalindrome(v)) ans++;
        }
        for (long i = 1; i <= 100000; i++) {
            String s = Long.toString(i);
            String t = new StringBuilder(s).reverse().toString().substring(1);
            long v = Long.parseLong(s + t);
            v *= v;
            if (v > r) break;
            if (v >= l && isPalindrome(v)) ans++;
        }
        return ans;
    }
    boolean isPalindrome(long x) {
        String s = Long.toString(x);
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}