class Solution {
    public boolean isNumber(String s) {
        
        s = s.trim();
        boolean hasE = false, hasDot = false, hasNum = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'e' || c == 'E') {
                if(hasE || !hasNum) return false;
                hasE = true;
                hasNum = false;
            } else if(c == '.') {
                if(hasE || hasDot) return false;
                hasDot = true;
            } else if(c == '+' || c == '-') {
                if(i != 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') return false;
            } else if(Character.isDigit(c)) {
                hasNum = true;
            } else {
                return false;
            }
        }
        return hasNum;
    }
}