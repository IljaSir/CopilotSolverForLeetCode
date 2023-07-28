class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        int n = queries.length;
        int m = items.length;
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        int i = 0;
        int max = 0;
        for (int q : queries) {
            while (i < m && items[i][0] <= q) {
                max = Math.max(max, items[i][1]);
                i++;
            }
            ans[i] = max;
        }
        return ans;
    }
}