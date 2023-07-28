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
        int ans = 0;
        int curA = capacityA;
        int curB = capacityB;
        for (int i = 0; i < n; i++) {
            if (curA < plants[i]) {
                curA = capacityA;
                ans++;
            }
            curA -= plants[i];
            if (curB < plants[n - i - 1]) {
                curB = capacityB;
                ans++;
            }
            curB -= plants[n - i - 1];
        }
        return ans;
    }
}