class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            pq.add(gift);
        }
        while (k-- > 0) {
            int gift = pq.remove();
            int sqrt = (int) Math.sqrt(gift);
            int rest = gift - sqrt;
            if (rest > 0) {
                pq.add(rest);
            }
        }
        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.remove();
        }
        return sum;
    }
}