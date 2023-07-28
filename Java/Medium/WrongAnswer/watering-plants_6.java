class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        
        int res = 0;
        int cur = 0;
        for (int i = 0; i < plants.length; i++) {
            if (cur < plants[i]) {
                int d = plants[i] - cur;
                res += 2 * (i - 1);
                res += 1 + d / capacity + (d % capacity == 0 ? 0 : 1);
                cur = capacity - d % capacity;
            } else {
                cur -= plants[i];
            }
        }
        return res;
    }
}