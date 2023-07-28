class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < gifts.length; i++) {
            pq.add(gifts[i]);
        }
        while (k-- > 0) {
            int max = pq.poll();
            pq.add((int) Math.floor(Math.sqrt(max)));
        }
        long res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }
}