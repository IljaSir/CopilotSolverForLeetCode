class Solution {
    public String largestPalindromic(String num) {
        
        char[] chars = num.toCharArray();
        int[] counts = new int[10];
        for (char ch : chars) {
            counts[ch - '0']++;
        }
        int[] maxs = new int[10];
        for (int i = 0; i < 10; i++) {
            maxs[i] = counts[i] / 2;
        }
        char[] maxChars = new char[num.length() / 2];
        for (int i = 0; i < maxChars.length; i++) {
            for (int j = 9; j >= 0; j--) {
                if (maxs[j] > 0) {
                    maxs[j]--;
                    maxChars[i] = (char) ('0' + j);
                    break;
                }
            }
        }
        String max = new String(maxChars);
        if (num.length() % 2 == 0) {
            return max + new StringBuilder(max).reverse().toString();
        } else {
            for (int j = 9; j >= 0; j--) {
                if (counts[j] % 2 == 1) {
                    return max + (char) ('0' + j) + new StringBuilder(max).reverse().toString();
                }
            }
            return max + new StringBuilder(max).reverse().toString();
        }
    }
}