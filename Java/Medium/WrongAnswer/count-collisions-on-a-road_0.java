class Solution {
    public int countCollisions(String directions) {
        
        int collision = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < directions.length(); i++) {
            if (directions.charAt(i) == 'L') {
                left++;
            } else if (directions.charAt(i) == 'R') {
                right++;
            } else {
                collision += Math.min(left, right);
            }
        }
        return collision;
    }
}