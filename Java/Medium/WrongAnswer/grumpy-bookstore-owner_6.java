class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int n = customers.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
                customers[i] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefix[i] = customers[i];
            } else {
                prefix[i] = prefix[i - 1] + customers[i];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                suffix[i] = customers[i];
            } else {
                suffix[i] = suffix[i + 1] + customers[i];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int left = i - minutes < 0 ? 0 : prefix[i - minutes];
            int right = i + minutes >= n ? 0 : suffix[i + minutes];
            max = Math.max(max, left + right);
        }
        return max + total;
    }
}