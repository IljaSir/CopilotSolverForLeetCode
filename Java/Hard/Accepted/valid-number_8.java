class Solution {
    public boolean isNumber(String s) {
        
        if (s == null || s.isEmpty()) {
            return false;
        }
        int i = 0;
        int n = s.length();
        // skip leading whitespaces
        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        // skip leading sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        boolean isNumber = false;
        // skip leading digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumber = true;
        }
        // skip a dot
        if (i < n && s.charAt(i) == '.') {
            i++;
        }
        // skip digits after dot
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumber = true;
        }
        // skip 'e' or 'E'
        if (i < n && isNumber && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;
            isNumber = false;
            // skip sign
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            // skip digits after 'e' or 'E'
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumber = true;
            }
        }
        // skip trailing whitespaces
        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        return isNumber && i == n;
    }
}