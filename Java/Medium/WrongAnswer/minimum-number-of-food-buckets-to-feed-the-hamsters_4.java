class Solution {
    public int minimumBuckets(String hamsters) {
        
        int n = hamsters.length();
        int[] left = new int[n];
        int[] right = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                count++;
                left[i] = 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (hamsters.charAt(i) == 'H') {
                right[i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            left[i] += left[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] += right[i + 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == '.') {
                ans = Math.min(ans, left[i] + right[i]);
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return count - ans;
    }
}