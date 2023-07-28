class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        
        long[] result = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = kthPalindrome(queries[i], intLength);
        }
        return result;
    }
    public long kthPalindrome(int query, int intLength) {
        int halfLength = intLength / 2;
        long[] result = new long[query];
        int index = 0;
        for (int i = 1; i < Math.pow(10, halfLength); i++) {
            String str = String.valueOf(i);
            String strReverse = new StringBuffer(str).reverse().toString();
            String palindrome = str + strReverse;
            if (palindrome.length() == intLength) {
                result[index++] = Long.parseLong(palindrome);
            }
        }
        Arrays.sort(result);
        return query > result.length ? -1 : result[query - 1];
    }
}