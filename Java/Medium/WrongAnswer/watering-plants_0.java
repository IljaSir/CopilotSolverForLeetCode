class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        
        int n = plants.length;
        int steps = 0;
        int water = 0;
        for (int i = 0; i < n; i++) {
            if (water < plants[i]) {
                steps += 2 * (i + 1);
                water = capacity;
            }
            water -= plants[i];
            steps++;
        }
        return steps - 1;
    }
}