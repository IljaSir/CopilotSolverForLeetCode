class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        
        int n = plants.length;
        int a = 0, b = n - 1;
        int refills = 0;
        int ca = capacityA, cb = capacityB;
        while (a <= b) {
            if (ca >= plants[a]) {
                ca -= plants[a];
                a++;
            } else if (cb >= plants[b]) {
                cb -= plants[b];
                b--;
            } else {
                ca = capacityA;
                cb = capacityB;
                refills++;
            }
        }
        return refills;
    }
}