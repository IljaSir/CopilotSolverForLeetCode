class Solution {
    public int countCollisions(String directions) {
        
        int n = directions.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (directions.charAt(i) == 'L') {
                l++;
            } else if (directions.charAt(i) == 'R') {
                r++;
            }
            left[i] = l;
            right[i] = r;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (directions.charAt(i) == 'L') {
                res += right[i];
            } else if (directions.charAt(i) == 'R') {
                res += left[i];
            }
        }
        return res;
    }
}