class Solution {
    public boolean isNumber(String s) {
        
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean hasDot = false;
        boolean hasE = false;
        boolean hasDigit = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (hasE || !hasDigit) {
                    return false;
                }
                hasE = true;
                hasDigit = false;
            } else if (c >= '0' && c <= '9') {
                hasDigit = true;
            } else {
                return false;
            }
        }
        return hasDigit;
    }
}