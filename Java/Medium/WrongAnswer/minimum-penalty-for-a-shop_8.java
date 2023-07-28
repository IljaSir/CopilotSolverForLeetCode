class Solution {
    public int bestClosingTime(String customers) {
        
        int n = customers.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sum[i] = customers.charAt(i) == 'Y' ? 1 : 0;
            } else {
                sum[i] = sum[i - 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                left[i] = customers.charAt(i) == 'Y' ? 1 : 0;
            } else {
                left[i] = left[i - 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                right[i] = customers.charAt(i) == 'Y' ? 1 : 0;
            } else {
                right[i] = right[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
            }
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int penalty = 0;
            if (i == 0) {
                penalty = sum[n - 1];
            } else if (i == n - 1) {
                penalty = sum[n - 2];
            } else {
                penalty = left[i - 1] + right[i + 1];
            }
            if (penalty < min) {
                min = penalty;
                ans = i;
            }
        }
        return ans;
    }
}