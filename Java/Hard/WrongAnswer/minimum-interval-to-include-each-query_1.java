class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        int n = intervals.length;
        int m = queries.length;
        int[][] qs = new int[m][2];
        for (int i = 0; i < m; i++) {
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        Arrays.sort(qs, (a, b) -> a[0] - b[0]);
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && intervals[j][1] <= qs[i][0]) {
                map.put(intervals[j][0], map.getOrDefault(intervals[j][0], 0) + 1);
                j++;
            }
            if (!map.isEmpty()) {
                if (map.firstKey() <= qs[i][0]) {
                    ans[qs[i][1]] = map.firstEntry().getValue();
                }
                if (ans[qs[i][1]] != -1) {
                    int key = map.firstKey();
                    map.put(key, map.get(key) - 1);
                    if (map.get(key) == 0) {
                        map.remove(key);
                    }
                }
            }
        }
        return ans;
    }
}