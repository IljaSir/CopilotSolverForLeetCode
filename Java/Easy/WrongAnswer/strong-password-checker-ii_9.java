class Solution {
    public boolean strongPasswordCheckerII(String password) {
        
        int len = password.length();
        if(len < 8) return false;
        boolean hasUpper = false, hasLower = false, hasDigit = false;
        for(char c : password.toCharArray()) {
            if(Character.isUpperCase(c)) hasUpper = true;
            else if(Character.isLowerCase(c)) hasLower = true;
            else if(Character.isDigit(c)) hasDigit = true;
        }
        if(!hasUpper || !hasLower || !hasDigit) return false;
        return true;
    }
}