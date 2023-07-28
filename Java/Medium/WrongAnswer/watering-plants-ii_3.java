class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        
        int n = plants.length;
        int i = 0, j = n - 1;
        int a = 0, b = 0;
        int count = 0;
        while (i <= j) {
            if (a < plants[i]) {
                a = capacityA;
                count++;
            }
            a -= plants[i];
            i++;
            if (i > j) {
                break;
            }
            if (b < plants[j]) {
                b = capacityB;
                count++;
            }
            b -= plants[j];
            j--;
        }
        return count;
    }
}