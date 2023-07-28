class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : gifts) pq.add(i);
        while(k-- > 0) {
            int x = (int) Math.sqrt(pq.poll());
            pq.add(x);
        }
        long ans = 0;
        for(int i : pq) ans += i;
        return ans;
    }
}