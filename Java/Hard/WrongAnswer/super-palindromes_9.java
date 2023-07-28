class Solution {
    public int superpalindromesInRange(String left, String right) {
        
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        int res = 0;
        for (long i = (long) Math.sqrt(l); i <= Math.sqrt(r); i++) {
            long p = Long.parseLong(i + new StringBuilder().append(i).reverse().toString());
            if (p * p > r) continue;
            if (isPalindrome(p * p)) res++;
        }
        for (long i = (long) Math.sqrt(l); i <= Math.sqrt(r); i++) {
            long p = Long.parseLong(i + new StringBuilder().append(i).reverse().deleteCharAt(0).toString());
            if (p * p > r) continue;
            if (isPalindrome(p * p)) res++;
        }
        return res;
    }

    boolean isPalindrome(long x) {
        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}