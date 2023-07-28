class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        int m = intervals.length;
        int n = queries.length;
        int[][] q = new int[n][2];
        for(int i = 0; i < n; i++){
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        Arrays.sort(q, (a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int idx = 0;
        for(int i = 0; i < n; i++){
            while(idx < m && intervals[idx][1] <= q[i][0]){
                pq.offer(intervals[idx++]);
            }
            while(!pq.isEmpty() && pq.peek()[0] < q[i][0]){
                pq.poll();
            }
            if(!pq.isEmpty()){
                ans[q[i][1]] = pq.peek()[1] - pq.peek()[0] + 1;
            }
        }
        return ans;
    }
}