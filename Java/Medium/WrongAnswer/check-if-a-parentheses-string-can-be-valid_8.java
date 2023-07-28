class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int n = s.length();
        int[] open = new int[n];
        int[] close = new int[n];
        int[] lock = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                sum++;
            } else {
                sum--;
            }
            if (locked.charAt(i) == '0') {
                lock[i] = 1;
            }
            open[i] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                sum++;
            } else {
                sum--;
            }
            close[i] = sum;
        }
        for (int i = 0; i < n; i++) {
            if (open[i] < 0) {
                if (i + open[i] < 0) {
                    return false;
                }
                if (lock[i + open[i]] == 0) {
                    return false;
                }
                lock[i + open[i]] = 0;
            }
            if (close[i] < 0) {
                if (i + close[i] < 0) {
                    return false;
                }
                if (lock[i + close[i]] == 0) {
                    return false;
                }
                lock[i + close[i]] = 0;
            }
        }
        return true;
    }
}