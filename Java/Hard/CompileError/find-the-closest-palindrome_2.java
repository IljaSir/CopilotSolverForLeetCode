class Solution {
    public String nearestPalindromic(String n) {
        
        int len = n.length();
        if (len == 1) {
            return String.valueOf(Integer.parseInt(n) - 1);
        }
        long num = Long.parseLong(n);
        long left = Long.parseLong(n.substring(0, (len + 1) / 2));
        long[] candidates = new long[3];
        candidates[0] = getPalindrome(left);
        candidates[1] = getPalindrome(left - 1);
        candidates[2] = getPalindrome(left + 1);
        long minDiff = Long.MAX_VALUE;
        long ans = 0;
        for (long candidate : candidates) {
            long diff = Math.abs(candidate - num);
            if (diff == 0) {
                continue;
            }
            if (diff < minDiff) {
                minDiff = diff;
                ans = candidate;
            } else if (diff == minDiff) {
                ans = Math.min(ans, candidate);
            }
        }
        long min = (long)Math.pow(10, len - 1) - 1;
        long max = (long)Math.pow(10, len) + 1;
        if (minDiff > max - num) {
            ans = min;
        } else if (minDiff > num - min) {
            ans = max;
        }
        return String.valueOf(ans);
    }
}