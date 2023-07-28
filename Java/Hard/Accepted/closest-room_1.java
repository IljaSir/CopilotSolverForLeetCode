class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        
        int n = rooms.length;
        int m = queries.length;
        int[] res = new int[m];
        int[][] q = new int[m][3];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        Arrays.sort(q, (a, b) -> b[1] - a[1]);
        TreeSet<Integer> set = new TreeSet<>();
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && rooms[j][1] >= q[i][1]) {
                set.add(rooms[j++][0]);
            }
            Integer floor = set.floor(q[i][0]);
            Integer ceil = set.ceiling(q[i][0]);
            if (floor == null && ceil == null) {
                res[q[i][2]] = -1;
            } else if (floor == null) {
                res[q[i][2]] = ceil;
            } else if (ceil == null) {
                res[q[i][2]] = floor;
            } else {
                res[q[i][2]] = Math.abs(ceil - q[i][0]) < Math.abs(floor - q[i][0]) ? ceil : floor;
            }
        }
        return res;
    }
}