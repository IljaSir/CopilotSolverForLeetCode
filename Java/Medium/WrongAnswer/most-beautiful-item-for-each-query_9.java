class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        int n = queries.length;
        int[] ans = new int[n];
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int[] pre = new int[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            pre[i + 1] = Math.max(pre[i], items[i][1]);
        }
        for (int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(items, new int[]{queries[i], 0}, (a, b) -> a[0] - b[0]);
            if (idx < 0) {
                idx = -idx - 2;
            }
            ans[i] = Math.max(pre[idx + 1], ans[i]);
            if (i > 0) {
                ans[i] = Math.max(ans[i], ans[i - 1]);
            }
        }
        return ans;
    }
}