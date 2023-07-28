class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        
        int n = rooms.length;
        int m = queries.length;
        int[] res = new int[m];
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; ++i) {
            idx[i] = i;
        }
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        Arrays.sort(idx, (a, b) -> queries[b][1] - queries[a][1]);
        TreeSet<Integer> set = new TreeSet<>();
        int j = 0;
        for (int i = 0; i < m; ++i) {
            int[] q = queries[idx[i]];
            while (j < n && rooms[j][1] >= q[1]) {
                set.add(rooms[j][0]);
                ++j;
            }
            if (set.isEmpty()) {
                res[idx[i]] = -1;
            } else {
                Integer l = set.floor(q[0]);
                Integer r = set.ceiling(q[0]);
                if (l == null) {
                    res[idx[i]] = r;
                } else if (r == null) {
                    res[idx[i]] = l;
                } else if (q[0] - l <= r - q[0]) {
                    res[idx[i]] = l;
                } else {
                    res[idx[i]] = r;
                }
            }
        }
        return res;
    }
}