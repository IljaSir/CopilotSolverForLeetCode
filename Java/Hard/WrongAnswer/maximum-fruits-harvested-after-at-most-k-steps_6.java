class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        int n = fruits.length;
        int[] prefix = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + fruits[i-1][1];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = fruits[i][0];
            int right = left + k;
            int j = binarySearch(fruits, right);
            int cur = 0;
            if (j >= i) {
                cur = prefix[j+1] - prefix[i];
            } else {
                cur = prefix[j+1] + prefix[n] - prefix[i];
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
    private int binarySearch(int[][] fruits, int target) {
        int lo = 0;
        int hi = fruits.length-1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (fruits[mid][0] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}