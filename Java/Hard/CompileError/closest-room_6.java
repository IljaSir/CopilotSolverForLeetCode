class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        
        int n = rooms.length;
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        int[] idx = new int[m];
        for (int i = 0; i < m; i++) {
            idx[i] = i;
        }
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        Arrays.sort(idx, (a, b) -> queries[b][1] - queries[a][1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        int j = 0;
        for (int i = 0; i < m; i++) {
            int[] q = queries[idx[i]];
            while (j < n && rooms[j][1] >= q[1]) {
                pq.add(new int[]{rooms[j][0], rooms[j][1]});
                j++;
            }
            while (!pq.isEmpty() && pq.peek()[0] > q[0]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans[idx[i]] = pq.peek()[0];
            }
        }
        return ans;
    }
}