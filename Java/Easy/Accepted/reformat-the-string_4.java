class Solution {
    public String reformat(String s) {
        
        int n = s.length();
        char[] chars = new char[n];
        char[] digits = new char[n];
        int charCount = 0;
        int digitCount = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digits[digitCount++] = c;
            } else {
                chars[charCount++] = c;
            }
        }
        if (Math.abs(charCount - digitCount) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (charCount > digitCount) {
            for (int i = 0; i < charCount; i++) {
                sb.append(chars[i]);
                if (i < digitCount) {
                    sb.append(digits[i]);
                }
            }
        } else {
            for (int i = 0; i < digitCount; i++) {
                sb.append(digits[i]);
                if (i < charCount) {
                    sb.append(chars[i]);
                }
            }
        }
        return sb.toString();
    }
}