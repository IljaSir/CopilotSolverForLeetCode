class Solution {
    public int superpalindromesInRange(String left, String right) {
        
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        int ans = 0;
        for (int i = 1; i <= 100000; i++) {
            String s = String.valueOf(i);
            String t = new StringBuilder(s).reverse().toString();
            long v = Long.parseLong(s + t);
            long vv = v * v;
            if (vv > r) break;
            if (vv >= l && isPalindrome(vv)) ans++;
        }
        for (int i = 1; i <= 100000; i++) {
            String s = String.valueOf(i);
            String t = new StringBuilder(s).deleteCharAt(s.length() - 1).reverse().toString();
            long v = Long.parseLong(s + t);
            long vv = v * v;
            if (vv > r) break;
            if (vv >= l && isPalindrome(vv)) ans++;
        }
        return ans;
    }
    private boolean isPalindrome(long x) {
        String s = String.valueOf(x);
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}