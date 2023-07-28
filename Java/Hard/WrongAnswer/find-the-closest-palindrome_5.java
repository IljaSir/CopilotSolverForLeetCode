class Solution {
    public String nearestPalindromic(String n) {
        
        int len = n.length();
        int mid = len / 2;
        long num = Long.parseLong(n);
        long min = Long.MAX_VALUE;
        long ans = 0;
        long prefix = Long.parseLong(n.substring(0, mid));
        long[] candidates = new long[]{
            (long)Math.pow(10, len) + 1,
            (long)Math.pow(10, len - 1) - 1,
            (long)Math.pow(10, len - 1),
            (long)Math.pow(10, len - 1) + 1
        };
        for (long i : candidates) {
            long diff = Math.abs(i - num);
            if (diff != 0 && diff < min) {
                ans = i;
                min = diff;
            }
        }
        for (long i = -1; i <= 1; i++) {
            long p = prefix + i;
            StringBuilder sb = new StringBuilder(Long.toString(p));
            for (int j = mid - 1; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }
            long cand = Long.parseLong(sb.toString());
            long diff = Math.abs(cand - num);
            if (diff != 0 && diff < min) {
                ans = cand;
                min = diff;
            }
        }
        return Long.toString(ans);
    }
}