class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        
        long[] answer = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = findPalindrome(queries[i], intLength);
        }
        return answer;
    }
    public long findPalindrome(int query, int intLength) {
        long[] palindromes = new long[1000000];
        int index = 0;
        for (int i = 1; i <= 999999; i++) {
            String str = String.valueOf(i);
            String strReverse = new StringBuilder(str).reverse().toString();
            if (str.equals(strReverse)) {
                palindromes[index++] = Long.valueOf(str);
            }
        }
        Arrays.sort(palindromes);
        long result = -1;
        for (int i = 0; i < palindromes.length; i++) {
            if (palindromes[i] >= Math.pow(10, intLength - 1)) {
                result = palindromes[i + query - 1];
                break;
            }
        }
        return result;
    }
}