class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        
        int n = plants.length;
        int i = 0, j = n - 1;
        int count = 0;
        int a = capacityA, b = capacityB;
        while (i <= j) {
            if (a >= plants[i] && b >= plants[j]) {
                if (a >= b) {
                    a -= plants[i];
                    i++;
                } else {
                    b -= plants[j];
                    j--;
                }
            } else if (a >= plants[i]) {
                a -= plants[i];
                i++;
            } else if (b >= plants[j]) {
                b -= plants[j];
                j--;
            } else {
                a = capacityA;
                b = capacityB;
                count++;
            }
        }
        return count;
    }
}