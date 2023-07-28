class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        for (int i = 0; i < asteroids.length; i++) {
            if (mass >= asteroids[i]) {
                mass += asteroids[i];
            }
        }
        return mass >= asteroids[asteroids.length - 1];
    }
}