class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < gifts.length; i++) {
            pq.add(gifts[i]);
        }
        for (int i = 0; i < k; i++) {
            int max = pq.poll();
            int left = (int) Math.floor(Math.sqrt(max));
            max -= left;
            pq.add(max);
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}