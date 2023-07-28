class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        int len = s.length();
        for (int i = 1; i * 2 <= len; i++) {
            if (len % i == 0) {
                boolean match = true;
                for (int j = i; j < len; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}