class Solution {
    public String largestPalindromic(String num) {
        
        int[] digits = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            digits[i] = num.charAt(i) - '0';
        }
        Arrays.sort(digits);
        if (digits[digits.length - 1] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            sb.append(digits[i]);
        }
        return sb.toString();
    }
}