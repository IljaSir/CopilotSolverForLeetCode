class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        
        int sum = 0;
        for (int a : asteroids) {
            sum += a;
        }
        return sum <= mass;
    }
}