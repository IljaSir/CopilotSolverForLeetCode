class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        int n = asteroids.length;
        int i = 0;
        while (i < n) {
            if (mass >= asteroids[i]) {
                mass += asteroids[i];
                i++;
            } else {
                break;
            }
        }
        return i == n;
    }
}