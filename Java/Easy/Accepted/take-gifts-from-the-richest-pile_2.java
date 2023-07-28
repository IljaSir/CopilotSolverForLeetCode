class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < gifts.length; i++) {
            pq.add(gifts[i]);
        }
        for(int i = 0; i < k; i++) {
            int top = pq.poll();
            pq.add((int)Math.floor(Math.sqrt(top)));
        }
        long sum = 0;
        for(Integer i : pq) {
            sum += i;
        }
        return sum;
    }
}