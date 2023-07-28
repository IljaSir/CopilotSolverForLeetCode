class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        Arrays.sort(asteroids);
        for (int asteroid : asteroids) {
            mass = Math.max(mass, mass + asteroid);
        }
        return mass >= asteroids[asteroids.length - 1];
    }
}