class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        
        int steps = 0;
        int currentWater = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (currentWater < plants[i]) {
                steps += 2 * (i + 1);
                currentWater = capacity;
            }
            steps++;
            currentWater -= plants[i];
        }
        return steps;
    }
}