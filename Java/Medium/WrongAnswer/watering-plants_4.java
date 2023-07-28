class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        
        int steps = 0;
        int water = 0;
        for (int i = 0; i < plants.length; i++) {
            if (water < plants[i]) {
                int refill = plants[i] - water;
                steps += refill;
                water += refill;
            }
            water -= plants[i];
            steps++;
        }
        return steps - 1;
    }
}