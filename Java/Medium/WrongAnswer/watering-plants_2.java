class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        
        int n = plants.length;
        int i = 0;
        int steps = 0;
        int water = capacity;
        while (i < n) {
            if (water >= plants[i]) {
                water -= plants[i];
                i++;
            } else {
                water = capacity;
                steps += 2;
            }
            steps++;
        }
        return steps;
    }
}