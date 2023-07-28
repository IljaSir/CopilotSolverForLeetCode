class Solution {
    public boolean rotateString(String s, String goal) {
        
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;
        for (int i = 0; i < s.length(); i++) {
            String r = s.substring(i) + s.substring(0, i);
            if (r.equals(goal)) return true;
        }
        return false;
    }
}