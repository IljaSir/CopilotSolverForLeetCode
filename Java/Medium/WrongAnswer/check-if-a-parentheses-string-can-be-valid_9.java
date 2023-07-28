class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int n = s.length();
        int m = locked.length();
        if (n != m) {
            return false;
        }
        int[] balance = new int[n];
        int[] lockedInt = new int[n];
        for (int i = 0; i < n; i++) {
            lockedInt[i] = locked.charAt(i) - '0';
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                balance[i] = s.charAt(i) == '(' ? 1 : -1;
            } else {
                balance[i] = balance[i - 1] + (s.charAt(i) == '(' ? 1 : -1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (lockedInt[i] == 1) {
                min = Math.min(min, balance[i]);
            }
        }
        if (min < 0) {
            return false;
        }
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (lockedInt[i] == 1) {
                max = Math.max(max, balance[i]);
            }
        }
        return max >= 0;
    }
}