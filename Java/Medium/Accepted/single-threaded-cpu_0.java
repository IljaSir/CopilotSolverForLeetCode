class Solution {
    public int[] getOrder(int[][] tasks) {
        
        int n = tasks.length;
        int[][] t = new int[n][3];
        for (int i = 0; i < n; i++) {
            t[i][0] = tasks[i][0];
            t[i][1] = tasks[i][1];
            t[i][2] = i;
        }
        Arrays.sort(t, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int[] res = new int[n];
        int i = 0, j = 0, time = 0;
        while (j < n) {
            while (j < n && t[j][0] <= time) {
                pq.add(new int[]{t[j][0], t[j][1], t[j][2]});
                j++;
            }
            if (pq.isEmpty()) {
                time = t[j][0];
                continue;
            }
            int[] cur = pq.poll();
            time += cur[1];
            res[i++] = cur[2];
        }
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            res[i++] = cur[2];
        }
        return res;
    }
}