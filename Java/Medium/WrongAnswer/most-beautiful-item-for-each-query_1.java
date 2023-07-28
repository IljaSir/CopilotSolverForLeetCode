class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        int n = items.length;
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int price = items[i][0];
            int beauty = items[i][1];
            if (map.containsKey(price)) {
                map.put(price, Math.max(map.get(price), beauty));
            } else {
                map.put(price, beauty);
            }
        }
        int[] ans = new int[queries.length];
        int[] prefixMax = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, items[i][1]);
            prefixMax[i] = max;
        }
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            Integer key = map.floorKey(query);
            if (key == null) {
                ans[i] = 0;
            } else {
                ans[i] = map.get(key);
            }
        }
        return ans;
    }
}