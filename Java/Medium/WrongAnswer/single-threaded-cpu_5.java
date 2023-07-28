class Solution {
    public int[] getOrder(int[][] tasks) {
        
        int n = tasks.length;
        int[] res = new int[n];
        int[][] t = new int[n][3];
        for (int i = 0; i < n; i++) {
            t[i][0] = tasks[i][0];
            t[i][1] = tasks[i][1];
            t[i][2] = i;
        }
        Arrays.sort(t, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int i = 0;
        long time = 0;
        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                time = t[i][0];
            }
            while (i < n && t[i][0] <= time) {
                pq.offer(t[i++]);
            }
            int[] cur = pq.poll();
            res[cur[2]] = (int) time;
            time += cur[1];
        }
        return res;
    }
}