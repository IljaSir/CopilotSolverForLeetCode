class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        int n = intervals.length;
        int m = queries.length;
        int[][] qs = new int[m][2];
        for (int i = 0; i < m; ++i) {
            qs[i] = new int[] {queries[i], i};
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        Arrays.sort(qs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int j = 0;
        for (int i = 0; i < m; ++i) {
            while (j < n && intervals[j][1] <= qs[i][0]) {
                int l = intervals[j][0];
                int r = intervals[j][1];
                map.put(r - l + 1, map.getOrDefault(r - l + 1, 0) + 1);
                ++j;
            }
            if (map.isEmpty()) {
                continue;
            }
            Map.Entry<Integer, Integer> e = map.ceilingEntry(qs[i][0]);
            if (e != null) {
                ans[qs[i][1]] = e.getKey();
                if (e.getValue() == 1) {
                    map.remove(e.getKey());
                } else {
                    map.put(e.getKey(), e.getValue() - 1);
                }
            }
        }
        return ans;
    }
}