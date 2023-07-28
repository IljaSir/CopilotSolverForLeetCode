class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        
        int MOD = 1_000_000_007;
        Arrays.sort(packages);
        int n = packages.length;
        long[] preSum = new long[n];
        preSum[0] = packages[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + packages[i];
        }
        long ans = Long.MAX_VALUE;
        for (int[] box : boxes) {
            Arrays.sort(box);
            if (box[box.length - 1] < packages[n - 1]) {
                continue;
            }
            long cur = 0;
            int i = 0;
            for (int size : box) {
                int j = upperBound(packages, size);
                cur += (long) size * (j - i) - (preSum[j - 1] - (i > 0 ? preSum[i - 1] : 0));
                i = j;
                if (i == n) {
                    break;
                }
            }
            ans = Math.min(ans, cur);
        }
        return ans == Long.MAX_VALUE ? -1 : (int) (ans % MOD);
    }

    public int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if (nums[high] <= target) {
            return high + 1;
        }
        while (low < high) {
            int mid = low + high >> 1;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}