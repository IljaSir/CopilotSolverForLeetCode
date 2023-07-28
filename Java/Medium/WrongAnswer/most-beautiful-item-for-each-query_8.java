class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        int[] result = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int max = 0;
        for (int i = 0; i < items.length; i++) {
            max = Math.max(max, items[i][1]);
            map.put(items[i][0], max);
        }
        for (int i = 0; i < queries.length; i++) {
            result[i] = map.getOrDefault(queries[i], 0);
        }
        return result;
    }
}