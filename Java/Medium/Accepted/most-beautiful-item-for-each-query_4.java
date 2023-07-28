class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        int[] ans = new int[queries.length];
        Arrays.sort(items, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });
        int[] max = new int[items.length];
        max[0] = items[0][1];
        for (int i = 1; i < items.length; i++) {
            max[i] = Math.max(max[i - 1], items[i][1]);
        }
        for (int i = 0; i < queries.length; i++) {
            int j = binarySearch(items, queries[i]);
            if (j >= 0) ans[i] = max[j];
        }
        return ans;
    }
    private int binarySearch(int[][] items, int target) {
        int l = 0;
        int r = items.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (items[m][0] == target) return m;
            if (items[m][0] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (items[l][0] <= target) return l;
        return l - 1;
    }
}