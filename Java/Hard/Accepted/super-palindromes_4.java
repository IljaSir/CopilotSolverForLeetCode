class Solution {
    public int superpalindromesInRange(String left, String right) {
        
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        int res = 0;
        for (long i = 1; i < 100000; i++) {
            String s = String.valueOf(i);
            for (int j = s.length() - 2; j >= 0; j--) {
                s += s.charAt(j);
            }
            long t = Long.parseLong(s);
            t *= t;
            if (t > r) {
                break;
            }
            if (t >= l && isPalindrome(t)) {
                res++;
            }
        }
        for (long i = 1; i < 100000; i++) {
            String s = String.valueOf(i);
            for (int j = s.length() - 1; j >= 0; j--) {
                s += s.charAt(j);
            }
            long t = Long.parseLong(s);
            t *= t;
            if (t > r) {
                break;
            }
            if (t >= l && isPalindrome(t)) {
                res++;
            }
        }
        return res;
    }

    public boolean isPalindrome(long x) {
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}