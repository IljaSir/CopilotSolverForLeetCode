class Solution {
    public int countCollisions(String directions) {
        
        int n = directions.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (directions.charAt(i) == 'L') {
                left[i] = 1;
            }
            if (i > 0) {
                left[i] += left[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (directions.charAt(i) == 'R') {
                right[i] = 1;
            }
            if (i < n - 1) {
                right[i] += right[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (directions.charAt(i) == 'S') {
                ans += left[i] + right[i];
            }
        }
        return ans;
    }
}