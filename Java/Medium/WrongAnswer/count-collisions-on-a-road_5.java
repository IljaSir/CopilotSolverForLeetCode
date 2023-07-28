class Solution {
    public int countCollisions(String directions) {
        
        int collisions = 0;
        int carCount = 0;
        for (int i = 0; i < directions.length(); i++) {
            if (directions.charAt(i) == 'L') {
                carCount++;
            } else if (directions.charAt(i) == 'R') {
                collisions += carCount;
            }
        }
        return collisions;
    }
}