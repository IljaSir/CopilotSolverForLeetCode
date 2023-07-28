class Solution {
    public String reformatNumber(String number) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                sb.append(number.charAt(i));
            }
        }
        String digits = sb.toString();
        int n = digits.length();
        sb = new StringBuilder();
        for (int i = 0; i < n; i += 3) {
            if (i + 4 <= n) {
                sb.append(digits.substring(i, i + 3)).append('-');
            } else if (i + 2 == n) {
                sb.append(digits.substring(i, i + 2));
            } else {
                sb.append(digits.substring(i, i + 3));
            }
        }
        return sb.toString();
    }
}