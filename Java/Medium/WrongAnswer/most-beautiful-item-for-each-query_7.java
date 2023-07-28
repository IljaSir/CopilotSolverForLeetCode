class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        int n = queries.length;
        int[] res = new int[n];
        int max = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while (j < items.length && items[j][0] <= queries[i]) {
                max = Math.max(max, items[j++][1]);
            }
            res[i] = max;
        }
        return res;
    }
}