class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        
        int n = plants.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = plants[0];
        right[n - 1] = plants[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + plants[i];
            right[n - i - 1] = right[n - i] + plants[n - i - 1];
        }
        int a = 0;
        int b = n - 1;
        int count = 0;
        while (a <= b) {
            if (left[a] <= capacityA && right[b] <= capacityB) {
                if (left[a] < right[b]) {
                    capacityA -= left[a];
                    capacityB -= left[a];
                    a++;
                } else {
                    capacityA -= right[b];
                    capacityB -= right[b];
                    b--;
                }
            } else if (left[a] <= capacityA) {
                capacityA -= left[a];
                capacityB -= left[a];
                a++;
            } else if (right[b] <= capacityB) {
                capacityA -= right[b];
                capacityB -= right[b];
                b--;
            } else {
                count++;
                capacityA = capacityB = Math.max(capacityA, capacityB);
            }
        }
        return count;
    }
}