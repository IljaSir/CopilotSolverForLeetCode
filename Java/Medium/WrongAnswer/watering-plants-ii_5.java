class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        
        int n = plants.length;
        int count = 0;
        int i = 0;
        int j = n - 1;
        int a = 0;
        int b = 0;
        while (i <= j) {
            if (a < plants[i]) {
                a = capacityA;
                count++;
            }
            if (b < plants[j]) {
                b = capacityB;
                count++;
            }
            a -= plants[i++];
            b -= plants[j--];
        }
        return count;
    }
}