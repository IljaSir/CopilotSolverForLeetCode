class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        
        long[] arr = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            arr[i] = getKthPalindrome(queries[i], intLength);
        }
        return arr;
    }

    private long getKthPalindrome(int k, int intLength) {
        if (intLength == 1) {
            return k;
        }
        long base = (long) Math.pow(10, intLength / 2);
        long left = (k - 1) / 25;
        long right = (k - 1) % 25;
        long mid = base + left;
        long pal = mid;
        long tmp = mid;
        while (tmp > 0) {
            pal = pal * 10 + tmp % 10;
            tmp /= 10;
        }
        if (intLength % 2 == 0) {
            return pal * (long) Math.pow(10, intLength / 2) + right;
        } else {
            return pal * (long) Math.pow(10, intLength / 2) + right / 5;
        }
    }
}