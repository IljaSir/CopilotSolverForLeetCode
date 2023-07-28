class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        
        int a = 0, b = plants.length - 1;
        int count = 0;
        int wa = 0, wb = 0;
        while (a <= b) {
            if (wa < plants[a]) {
                wa = capacityA;
                count++;
            }
            wa -= plants[a];
            a++;
            if (wb < plants[b]) {
                wb = capacityB;
                count++;
            }
            wb -= plants[b];
            b--;
        }
        return count;
    }
}