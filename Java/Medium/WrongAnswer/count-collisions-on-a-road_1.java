class Solution {
    public int countCollisions(String directions) {
        
        int n = directions.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (directions.charAt(i) == 'L') {
                l++;
            }
            left[i] = l;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            if (directions.charAt(i) == 'R') {
                r++;
            }
            right[i] = r;
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (directions.charAt(i) == 'S') {
                cnt += left[i] + right[i];
            }
        }
        return cnt;
    }
}