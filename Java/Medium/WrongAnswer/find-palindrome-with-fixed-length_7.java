class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        
        int intQueryLength = queries.length;
        long[] lngResult = new long[intQueryLength];
        for (int intIndex = 0; intIndex < intQueryLength; intIndex++) {
            int intQuery = queries[intIndex];
            lngResult[intIndex] = kthPalindrome(intQuery, intLength);
        }
        return lngResult;
    }
    private long kthPalindrome(int intQuery, int intLength) {
        if (intLength == 1) {
            return intQuery;
        }
        int intHalfLength = (intLength + 1) / 2;
        int intHalfMax = (int)Math.pow(10, intHalfLength) - 1;
        int intHalfMin = (int)Math.pow(10, intHalfLength - 1);
        int intHalf = intQuery;
        if (intHalf > intHalfMax) {
            intHalf = intHalfMax;
        }
        if (intHalf < intHalfMin) {
            intHalf = intHalfMin;
        }
        long lngResult = palindrome(intHalf, intLength);
        while (lngResult < intQuery) {
            intHalf++;
            lngResult = palindrome(intHalf, intLength);
        }
        return lngResult;
    }
    private long palindrome(int intHalf, int intLength) {
        int intHalfLength = (intLength + 1) / 2;
        int intHalfMax = (int)Math.pow(10, intHalfLength) - 1;
        int intHalfMin = (int)Math.pow(10, intHalfLength - 1);
        if (intHalf > intHalfMax) {
            return -1;
        }
        if (intHalf < intHalfMin) {
            return -1;
        }
        long lngResult = intHalf;
        for (int intIndex = intHalfLength - 1; intIndex >= 0; intIndex--) {
            lngResult = lngResult * 10 + (intHalf / (int)Math.pow(10, intIndex)) % 10;
        }
        return lngResult;
    }
}