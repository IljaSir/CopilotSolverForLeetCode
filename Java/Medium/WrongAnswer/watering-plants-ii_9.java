class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        
        int n = plants.length;
        int count = 0;
        int p1 = 0, p2 = n - 1;
        int a = capacityA, b = capacityB;
        while (p1 <= p2) {
            if (a < plants[p1] && b < plants[p2]) {
                count++;
                a = capacityA;
                b = capacityB;
            } else if (a >= plants[p1] && b >= plants[p2]) {
                if (p1 == p2) {
                    count++;
                    break;
                }
                if (a >= b) {
                    a -= plants[p1];
                    p1++;
                    b -= plants[p2];
                    p2--;
                } else {
                    b -= plants[p2];
                    p2--;
                    a -= plants[p1];
                    p1++;
                }
            } else if (a >= plants[p1]) {
                a -= plants[p1];
                p1++;
            } else if (b >= plants[p2]) {
                b -= plants[p2];
                p2--;
            }
        }
        return count;
    }
}