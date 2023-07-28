class Solution {
    public int superpalindromesInRange(String left, String right) {
        
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        int ans = 0;
        for (long i = 1; i <= 100000; i++) {
            String s = Long.toString(i);
            for (int k = s.length() - 2; k >= 0; k--) {
                s += s.charAt(k);
            }
            long v = Long.parseLong(s);
            v *= v;
            if (v > r) {
                break;
            }
            if (v >= l && isPalindromic(v)) {
                ans++;
            }
        }
        for (long i = 1; i <= 100000; i++) {
            String s = Long.toString(i);
            for (int k = s.length() - 1; k >= 0; k--) {
                s += s.charAt(k);
            }
            long v = Long.parseLong(s);
            v *= v;
            if (v > r) {
                break;
            }
            if (v >= l && isPalindromic(v)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isPalindromic(long x) {
        String s = Long.toString(x);
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}