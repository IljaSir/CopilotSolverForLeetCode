class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        
        long[] result = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = kthPalindrome(queries[i], intLength);
        }
        return result;
    }
    
    private long kthPalindrome(int k, int intLength) {
        long min = (long) Math.pow(10, intLength - 1);
        long max = (long) Math.pow(10, intLength) - 1;
        long mid = 0;
        long count = 0;
        while (min <= max) {
            mid = min + (max - min) / 2;
            count = countPalindrome(mid, intLength);
            if (count == k) {
                return mid;
            } else if (count < k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return -1;
    }
    
    private long countPalindrome(long n, int intLength) {
        long count = 0;
        for (int i = 1; i <= intLength / 2; i++) {
            count += (n / (long) Math.pow(10, i)) * (long) Math.pow(10, i - 1);
        }
        for (int i = 1; i <= intLength / 2; i++) {
            count += (n / (long) Math.pow(10, i)) * (long) Math.pow(10, i - 1);
        }
        if (intLength % 2 == 1) {
            count += (n / (long) Math.pow(10, intLength / 2)) * (long) Math.pow(10, intLength / 2);
        }
        return count;
    }
}