class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            pq.add(gift);
        }
        for (int i = 0; i < k; i++) {
            int gift = pq.poll();
            pq.add((int) Math.floor(Math.sqrt(gift)));
        }
        long ans = 0;
        for (int gift : pq) {
            ans += gift;
        }
        return ans;
    }
}