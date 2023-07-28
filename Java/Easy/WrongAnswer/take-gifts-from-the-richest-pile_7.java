class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        PriorityQueue<Long> maxHeap = new PriorityQueue<Long>(Collections.reverseOrder());
        for(int i = 0; i < gifts.length; i++) {
            maxHeap.add((long)gifts[i]);
        }
        for(int i = 0; i < k; i++) {
            long max = maxHeap.poll();
            maxHeap.add(max - (long)Math.sqrt(max));
        }
        long ans = 0;
        for(Long l : maxHeap) {
            ans += l;
        }
        return ans;
    }
}