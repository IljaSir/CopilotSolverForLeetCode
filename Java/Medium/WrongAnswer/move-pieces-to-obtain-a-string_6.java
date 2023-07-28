class Solution {
    public boolean canChange(String start, String target) {
        
        int n = start.length();
        int s = 0;
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (start.charAt(i) == 'L') {
                s--;
            }
            if (start.charAt(i) == 'R') {
                s++;
            }
            if (target.charAt(i) == 'L') {
                t--;
            }
            if (target.charAt(i) == 'R') {
                t++;
            }
            if (s < t) {
                return false;
            }
        }
        return s == t;
    }
}