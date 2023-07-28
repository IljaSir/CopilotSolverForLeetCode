class Solution {
    public boolean isValid(String s) {
        
        int n = s.length();
        if (n % 3 != 0) {
            return false;
        }
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == 'a') {
                if (i + 2 < n && s.charAt(i + 1) == 'b' && s.charAt(i + 2) == 'c') {
                    i += 3;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}