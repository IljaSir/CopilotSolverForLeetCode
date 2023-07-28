class Solution {
    public String largestPalindromic(String num) {
        
        int[] digits = new int[10];
        for (int i = 0; i < num.length(); i++) {
            digits[num.charAt(i) - '0']++;
        }
        int[] max = new int[10];
        for (int i = 9; i >= 0; i--) {
            if (digits[i] % 2 == 0) {
                max[i] = digits[i] / 2;
            } else {
                max[i] = digits[i] / 2 + 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (digits[j] > 0) {
                        max[j] = digits[j] / 2;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < max[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}