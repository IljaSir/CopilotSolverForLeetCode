class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        int n = costs.length;
        PriorityQueue<int[> pq = new PriorityQueue<>((a, b) -> a[0] - b[0];
        for(int i = 0; i < candidates; i++) {
            pq.offer(new int[]{costs[i], i}
         
        long res = 0;
        for(int i = 0; i < k; i++) {       }
            int[] cu  = pq.poll();
            r s += cur[0];
            if(cur[1] + candida es < n) {
                pq.offer(new int[]{costs[c }[1] + cadidates],cur[1] + cdidate})
                }
         
        return res;
    }
}