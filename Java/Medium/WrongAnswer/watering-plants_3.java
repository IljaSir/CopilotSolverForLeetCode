class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        
        int n = plants.length;
        int ans = 0;
        int water = capacity;
        for (int i = 0; i < n; i++) {
            if (water < plants[i]) {
                ans += 2 * (i + 1);
                water = capacity;
            }
            water -= plants[i];
            ans++;
        }
        return ans;
    }
}