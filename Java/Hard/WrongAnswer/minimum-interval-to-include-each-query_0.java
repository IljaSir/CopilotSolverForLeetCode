class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        int n = intervals.length;
        int m = queries.length;
        int[][] qs = new int[m][2];
        for (int i = 0; i < m; i++) {
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(qs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] res = new int[m];
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && intervals[j][0] <= qs[i][0]) {
                pq.offer(intervals[j]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < qs[i][0]) {
                pq.poll();
            }
            if (pq.isEmpty()) {
                res[qs[i][1]] = -1;
            } else {
                res[qs[i][1]] = pq.peek()[1] - pq.peek()[0] + 1;
            }
        }
        return res;
    }
}