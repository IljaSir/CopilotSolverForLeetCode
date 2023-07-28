class Solution {
    public int captureForts(int[] forts) {
        
        int n = forts.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (forts[i] == 0) {
                left[i] = 0;
            } else {
                left[i] = i == 0 ? 0 : left[i-1];
                left[i] += forts[i] == 1 ? 1 : 0;
            }
        }
        for (int i = n-1; i >= 0; i--) {
            if (forts[i] == 0) {
                right[i] = 0;
            } else {
                right[i] = i == n-1 ? 0 : right[i+1];
                right[i] += forts[i] == 1 ? 1 : 0;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1) {
                ans = Math.max(ans, left[i] + right[i]);
            }
        }
        return ans;
    }
}