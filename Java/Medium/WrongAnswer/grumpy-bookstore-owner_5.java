class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int n = customers.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                s += customers[i];
                customers[i] = 0;
            }
            if (i == 0) {
                left[i] = customers[i];
            } else {
                left[i] = left[i-1] + customers[i];
            }
        }
        for (int i = n-1; i >= 0; i--) {
            if (i == n-1) {
                right[i] = customers[i];
            } else {
                right[i] = right[i+1] + customers[i];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int l = i - minutes >= 0 ? left[i-minutes] : 0;
            int r = i + minutes < n ? right[i+minutes] : 0;
            max = Math.max(max, l + r);
        }
        return s + max;
    }
}