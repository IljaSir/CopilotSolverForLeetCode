class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int[][] q = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> a[0] - b[0]);
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int j = 0;
        for (int i = 0; i < q.length; i++) {
            while (j < n && intervals[j][0] <= q[i][0]) {
                map.put(intervals[j][1] - intervals[j][0] + 1, map.getOrDefault(intervals[j][1] - intervals[j][0] + 1, 0) + 1);
                j++;
            }
            while (!map.isEmpty() && map.firstKey() <= q[i][0]) {
                int val = map.get(map.firstKey());
                if (val == 1) {
                    map.remove(map.firstKey());
                } else {
                    map.put(map.firstKey(), val - 1);
                }
            }
            if (!map.isEmpty()) {
                ans[q[i][1]] = map.firstKey();
            }
        }
        return ans;
    }
}