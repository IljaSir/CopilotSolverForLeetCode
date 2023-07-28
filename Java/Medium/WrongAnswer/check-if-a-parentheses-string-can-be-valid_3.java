class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int n = s.length();
        int left = 0, right = 0;
        int lockedLeft = 0, lockedRight = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                if (locked.charAt(i) == '0') {
                    left++;
                } else {
                    lockedLeft++;
                }
            } else {
                if (locked.charAt(i) == '0') {
                    right++;
                } else {
                    lockedRight++;
                }
            }
        }
        return left + lockedLeft >= right + lockedRight;
    }
}