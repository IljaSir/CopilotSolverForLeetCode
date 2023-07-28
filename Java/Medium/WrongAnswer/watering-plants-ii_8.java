class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        
        int n = plants.length;
        int refill = 0;
        int a = capacityA, b = capacityB;
        for (int i = 0; i < n; i++) {
            if (a >= plants[i]) {
                a -= plants[i];
            } else {
                refill++;
                a = capacityA;
                a -= plants[i];
            }
            if (b >= plants[n - i - 1]) {
                b -= plants[n - i - 1];
            } else {
                refill++;
                b = capacityB;
                b -= plants[n - i - 1];
            }
        }
        return refill;
    }
}