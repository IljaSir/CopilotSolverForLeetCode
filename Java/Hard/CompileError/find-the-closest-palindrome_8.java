class Solution {
    public String nearestPalindromic(String n) {
        
        long num = Long.parseLong(n);
        int len = n.length();
        long diff = Long.MAX_VALUE;
        long base = (long)Math.pow(10, len);
        long res = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 1; i <= 2; i++) {
            long cur = base + i;
            long curDiff = Math.abs(num - cur);
            if (curDiff < diff) {
                diff = curDiff;
                res = cur;
            } else if (curDiff == diff) {
                res = Math.min(res, cur);
            }
            cur = base - i;
            curDiff = Math.abs(num - cur);
            if (curDiff < diff) {
                diff = curDiff;
                res = cur;
            } else if (curDiff == diff) {
                res = Math.min(res, cur);
            }
        }
        if (len > 1) {
            min = (long)Math.pow(10, len - 1) + 1;
            max = (long)Math.pow(10, len) - 1;
        }
        long cur = Long.parseLong(getPalindrome(n));
        long curDiff = Math.abs(num - cur);
        if (curDiff < diff) {
            diff = curDiff;
            res = cur;
        } else if (curDiff == diff) {
            res = Math.min(res, cur);
        }
        if (num - 1 >= min) {
            curDiff = num - 1 - cur;
            if (curDiff < diff) {
                diff = curDiff;
                res = num - 1;
            } else if (curDiff == diff) {
                res = Math.min(res, num - 1);
            }
        }
        if (num + 1 <= max) {
            curDiff = cur - (num + 1);
            if (curDiff < diff) {
                diff = curDiff;
                res = num + 1;
            } else if (curDiff == diff) {
                res = Math.min(res, num + 1);
            }
        }
        return String.valueOf(res);
    }
    private String getPalindrome(String n) {
        int len = n.length();
        if (len == 1) {
            return n;
        }
        String left = n.substring(0
    }
}