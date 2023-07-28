class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int n = s.length();
        int[] diff = new int[n];
        int open = 0;
        int close = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            diff[i] = open - close;
        }
        int min = 0;
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    min++;
                } else {
                    max--;
                }
            } else {
                if (s.charAt(i) == '(') {
                    min++;
                    max++;
                } else {
                    max--;
                }
            }
            if (min > 0) {
                min = 0;
            }
            if (max < 0) {
                return false;
            }
        }
        return diff[0] == 0;
    }
}