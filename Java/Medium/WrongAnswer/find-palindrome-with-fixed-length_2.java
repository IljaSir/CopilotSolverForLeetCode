class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        
        long[] answer = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = kthPalindrome(queries[i], intLength);
        }
        return answer;
    }

    private long kthPalindrome(int query, int intLength) {
        if (intLength == 1) {
            return query;
        }
        if (intLength == 2) {
            if (query > 9) {
                return -1;
            }
            return query * 10 + query;
        }
        int half = intLength / 2;
        int halfQuery = (int) Math.pow(10, half - 1);
        int base = (int) Math.pow(10, half);
        int halfBase = base / 10;
        int firstHalf = query / halfBase;
        int secondHalf = query % halfBase;
        long palindrome = 0;
        if (secondHalf > 0) {
            palindrome = firstHalf * base + secondHalf;
        } else {
            palindrome = firstHalf * base;
        }
        if (palindrome < query) {
            palindrome += base;
        }
        long firstHalfPalindrome = palindrome / base;
        long secondHalfPalindrome = palindrome % base;
        if (secondHalfPalindrome == 0) {
            secondHalfPalindrome = halfBase;
        }
        if (firstHalfPalindrome == secondHalfPalindrome) {
            return palindrome;
        }
        if (firstHalfPalindrome > secondHalfPalindrome) {
            palindrome -= base;
            firstHalfPalindrome = palindrome / base;
            secondHalfPalindrome = palindrome % base;
        }
        if (firstHalfPalindrome == secondHalfPalindrome) {
            return palindrome;
        }
        palindrome -= firstHalfPalindrome * halfBase;
        palindrome += secondHalfPalindrome * halfBase;
        return palindrome;
    }
}