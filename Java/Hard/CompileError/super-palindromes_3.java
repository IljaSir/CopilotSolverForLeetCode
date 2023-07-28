class Solution {
    public int superpalindromesInRange(String left, String right) {
        
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        int res = 0;
        for (long i = 1; i < 100000; i++) {
            String s = Long.toString(i);
            for (int j = s.length() - 2; j >= 0; j--)
                s += s.charAt(j);
            long v = Long.parseLong(s);
            v *= v;
            if (v > r) break;
            if (v >= l && isPalindrome(v)) res++;
        }
        for (long i = 1; i < 100000; i++) {
            String s = Long.toString(i);
            for (int j = s.length() - 1; j >= 0; j--)
                s += s.charAt(j);
            long v = Long.parseLong(s);
            v *= v;
            if (v > r) break;
            if (v >= l && isPalindrome(v)) res++;
        }
        return res;
    }
}