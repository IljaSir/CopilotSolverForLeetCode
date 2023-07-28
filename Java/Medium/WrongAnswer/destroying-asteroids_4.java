class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        int sum = 0;
        for (int i = 0; i < asteroids.length; i++) {
            sum += asteroids[i];
        }
        if (sum < mass) {
            return false;
        }
        return true;
    }
}