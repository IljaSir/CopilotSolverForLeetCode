class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        int[] res = new int[queries.length];
        Arrays.sort(items, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < queries.length; i++) {
            int maxBeauty = 0;
            for (int[] item : items) {
                if (item[0] <= queries[i]) {
                    maxBeauty = item[1];
                }
            }
            res[i] = maxBeauty;
        }
        return res;
    }
}