class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        
        int n = nums.length;
        long[] ans = new long[n];
        int[] segs = new int[n];
        for (int i = 0; i < n; i++) {
            segs[i] = i;
        }
        long[] segSum = new long[n];
        for (int i = 0; i < n; i++) {
            segSum[i] = nums[i];
        }
        long max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int x = removeQueries[i];
            max = Math.max(max, segSum[find(segs, x)]);
            ans[i] = max;
            if (x > 0 && find(segs, x - 1) == find(segs, x)) {
                union(segs, x - 1, x);
                segSum[find(segs, x)] = segSum[find(segs, x - 1)] + segSum[find(segs, x)];
            }
            if (x < n - 1 && find(segs, x + 1) == find(segs, x)) {
                union(segs, x, x + 1);
                segSum[find(segs, x)] = segSum[find(segs, x + 1)] + segSum[find(segs, x)];
            }
        }
        return ans;
    }

    private int find(int[] segs, int x) {
        if (segs[x] != x) {
            segs[x] = find(segs, segs[x]);
        }
        return segs[x];
    }
}