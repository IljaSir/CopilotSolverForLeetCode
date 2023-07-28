class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        
        int n = rooms.length;
        int m = queries.length;
        int[] res = new int[m];
        int[] index = new int[m];
        for (int i = 0; i < m; i++) {
            index[i] = i;
        }
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        Arrays.sort(index, (a, b) -> queries[b][1] - queries[a][1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int idx = 0;
        for (int i = 0; i < m; i++) {
            int[] q = queries[index[i]];
            while (idx < n && rooms[idx][1] >= q[1]) {
                pq.offer(new int[]{rooms[idx][0], rooms[idx][1]});
                idx++;
            }
            while (!pq.isEmpty() && pq.peek()[0] > q[0]) {
                pq.poll();
            }
            if (pq.isEmpty()) {
                res[index[i]] = -1;
            } else {
                res[index[i]] = pq.peek()[0];
            }
        }
        return res;
    }
}