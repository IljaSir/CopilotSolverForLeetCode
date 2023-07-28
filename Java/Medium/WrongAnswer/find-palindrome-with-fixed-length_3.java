class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        
        long[] result = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = findKthPalindrome(queries[i], intLength);
        }
        return result;
    }
    
    private long findKthPalindrome(int k, int intLength) {
        if (k > 10 * intLength) return -1;
        long base = (long) Math.pow(10, intLength - 1);
        long result = base;
        for (int i = 1; i < k; i++) {
            result = findNextPalindrome(result);
        }
        return result;
    }
    
    private long findNextPalindrome(long num) {
        long result = num + 1;
        int length = (int) Math.log10(result) + 1;
        long[] digits = new long[length];
        for (int i = 0; i < length; i++) {
            digits[i] = result % 10;
            result /= 10;
        }
        for (int i = 0; i < length / 2; i++) {
            if (digits[i] != digits[length - 1 - i]) {
                result = num + (long) Math.pow(10, length / 2 - i);
                return result;
            }
        }
        return result;
    }
}