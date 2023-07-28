class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        int n = costs.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < candidates; i++) {
            pq.offer(new int[]{costs[i], i});
        }
        long res = 0;
        for(int i = 0; i < k; i++) {
            int[] cur = pq.poll();
            res += cur[0];
            if(cur[1] + candidates < n) {
                pq.offer(new int[]{costs[cur[1] + candidates], cur[1] + candidates});
            }
        }
        return res;
    }
}