class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        
        long[] ret = new long[queries.length];
        long[] palindromes = new long[1000000];
        int count = 0;
        for (int i = 1; i < 10; i++) {
            palindromes[count] = i;
            count++;
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                palindromes[count] = i * 10 + j;
                count++;
            }
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    palindromes[count] = i * 100 + j * 10 + k;
                    count++;
                }
            }
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        palindromes[count] = i * 1000 + j * 100 + k * 10 + l;
                        count++;
                    }
                }
            }
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 10; m++) {
                            palindromes[count] = i * 10000 + j * 1000 + k * 100 + l * 10 + m;
                            count++;
                        }
                    }
                }
            }
        }
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l <
    }
}