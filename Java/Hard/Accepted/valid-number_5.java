class Solution {
    public boolean isNumber(String s) {
        
        s = s.trim();
        if (s.length() == 0) return false;
        if (s.length() == 1) {
            char c = s.charAt(0);
            return c >= '0' && c <= '9';
        }
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        boolean hasDot = false;
        boolean hasDigit = false;
        boolean hasE = false;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '.') {
                if (hasDot || hasE) return false;
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (hasE) return false;
                if (!hasDigit) return false;
                hasE = true;
                hasDigit = false;
                if (i == s.length() - 1) return false;
                if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                    i++;
                }
            } else if (c >= '0' && c <= '9') {
                hasDigit = true;
            } else {
                return false;
            }
            i++;
        }
        return hasDigit;
    }
}