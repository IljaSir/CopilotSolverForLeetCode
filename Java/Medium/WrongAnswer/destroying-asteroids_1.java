class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        int sum = mass;
        for (int i = 0; i < asteroids.length; i++) {
            sum += asteroids[i];
            if (sum >= 23) {
                return true;
            }
        }
        return false;
    }
}