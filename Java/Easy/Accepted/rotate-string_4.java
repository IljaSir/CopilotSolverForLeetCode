class Solution {
    public boolean rotateString(String s, String goal) {
        
        int n = s.length();
        int m = goal.length();
        if (n != m) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                boolean ok = true;
                for (int j = 0; j < n; j++) {
                    if (s.charAt((i + j) % n) != goal.charAt(j)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return true;
                }
            }
        }
        return false;
    }
}