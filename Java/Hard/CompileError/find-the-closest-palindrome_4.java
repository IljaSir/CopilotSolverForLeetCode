class Solution {
    public String nearestPalindromic(String n) {
        
        if (n.equals("1")) {
            return "0";
        }
        long num = Long.parseLong(n);
        long diff = Long.MAX_VALUE;
        long res = 0;
        long prefix = Long.parseLong(n.substring(0, (n.length() + 1) / 2));
        for (long i = -1; i <= 1; i++) {
            long cur = getPalindrome(prefix + i);
            if (cur == num) {
                continue;
            }
            if (Math.abs(cur - num) < diff) {
                diff = Math.abs(cur - num);
                res = cur;
            } else if (Math.abs(cur - num) == diff) {
                res = Math.min(res, cur);
            }
        }
        return String.valueOf(res);
    }
}