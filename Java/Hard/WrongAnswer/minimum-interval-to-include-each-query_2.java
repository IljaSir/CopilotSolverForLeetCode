class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        int[][] q = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, (a, b) -> a[0] - b[0]);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] res = new int[queries.length];
        int i = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int[] query : q){
            while(i < intervals.length && intervals[i][0] <= query[0]){
                pq.offer(intervals[i++]);
            }
            while(!pq.isEmpty() && pq.peek()[1] < query[0]){
                pq.poll();
            }
            res[query[1]] = pq.isEmpty() ? -1 : pq.peek()[1] - pq.peek()[0] + 1;
        }
        return res;
    }
}