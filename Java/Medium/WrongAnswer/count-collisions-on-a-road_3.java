class Solution {
    public int countCollisions(String directions) {
        
        int n = directions.length();
        int count = 0;
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (directions.charAt(i) == 'L') {
                left++;
            } else if (directions.charAt(i) == 'R') {
                right++;
            } else {
                count += Math.min(left, right);
            }
        }
        return count;
    }
}