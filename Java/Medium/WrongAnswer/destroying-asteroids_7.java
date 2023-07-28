class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        int totalMass = 0;
        for (int i = 0; i < asteroids.length; i++) {
            totalMass += asteroids[i];
        }
        return totalMass + mass >= asteroids[asteroids.length - 1];
    }
}