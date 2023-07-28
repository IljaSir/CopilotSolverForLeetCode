class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        Arrays.sort(items, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] result = new int[queries.length];
        int maxBeauty = 0;
        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            while (j < items.length && items[j][0] <= queries[i]) {
                maxBeauty = Math.max(maxBeauty, items[j][1]);
                j++;
            }
            result[i] = maxBeauty;
        }
        return result;
    }
}