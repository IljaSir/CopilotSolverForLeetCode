class Solution {
    public boolean rotateString(String s, String goal) {
        
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                if (goal.equals(s.substring(i) + s.substring(0, i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
    }
}