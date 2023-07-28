class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        if(k == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int p : piles) pq.add(p);
        while(k-- > 0) {
            int p = pq.poll();
            pq.add(p - p/2);
        }
        int res = 0;
        while(!pq.isEmpty()) res += pq.poll();
        return res;
    }
}