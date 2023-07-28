class Solution {
    public String largestPalindromic(String num) {
        
        int[] count = new int[10];
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }
        int[] res = new int[10];
        for (int i = 9; i >= 0; i--) {
            if (count[i] > 0) {
                res[i] = 1;
                count[i]--;
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            res[i] += count[i] / 2 * 2;
            count[i] %= 2;
        }
        for (int i = 9; i >= 0; i--) {
            if (count[i] > 0) {
                res[i]++;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < res[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}