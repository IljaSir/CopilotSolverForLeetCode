class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        
        long[] result = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = getKthPalindrome(queries[i], intLength);
        }
        return result;
    }
    private long getKthPalindrome(int k, int len) {
        if (len == 1) {
            return k;
        }
        int mid = len / 2;
        long firstHalf = 1;
        for (int i = 0; i < mid; i++) {
            firstHalf *= 10;
        }
        long result = 0;
        if (len % 2 == 0) {
            result = firstHalf + getKthPalindrome(k, len - 2);
        } else {
            long secondHalf = getKthPalindrome(k, len - 1);
            if (secondHalf == -1) {
                return -1;
            }
            result = firstHalf + secondHalf / 10;
        }
        if (result > Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }
}