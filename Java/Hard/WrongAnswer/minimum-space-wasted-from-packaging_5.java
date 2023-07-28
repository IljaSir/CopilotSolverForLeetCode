class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        
        int n = packages.length;
        int m = boxes.length;
        int MOD = 1000000007;
        Arrays.sort(packages);
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + packages[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            Arrays.sort(boxes[i]);
            if (boxes[i][boxes[i].length - 1] < packages[n - 1]) {
                continue;
            }
            int waste = 0;
            int l = 0;
            for (int j = 0; j < boxes[i].length; j++) {
                int r = search(packages, boxes[i][j]);
                waste = (int) ((waste + 1L * boxes[i][j] * (r - l) - (preSum[r] - preSum[l])) % MOD);
                l = r;
            }
            ans = Math.min(ans, waste);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int search(int[] packages, int target) {
        int l = 0;
        int r = packages.length - 1;
        int ans = packages.length;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (packages[mid] > target) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}