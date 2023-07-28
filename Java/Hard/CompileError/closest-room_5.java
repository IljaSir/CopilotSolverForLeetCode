class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        int n = queries.length;
        int[] ans = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> queries[b][1] - queries[a][1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int i = 0;
        for (int j : index) {
            while (i < rooms.length && rooms[i][1] >= queries[j][1]) {
                pq.offer(rooms[i]);
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[0] > queries[j][0]) {
                pq.poll();
            }
            if (pq.isEmpty()) {
                ans[j] = -1;
            } else {
                ans[j] = pq.peek()[0];
            }
        }
        return ans;
    }
}