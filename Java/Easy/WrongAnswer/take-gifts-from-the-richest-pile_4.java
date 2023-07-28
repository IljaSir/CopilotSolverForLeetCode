class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < gifts.length; i++) {
            q.add(gifts[i]);
        }
        while (k > 0) {
            int max = q.poll();
            q.add(max - (int)Math.floor(Math.sqrt(max)));
            k--;
        }
        long sum = 0;
        while (!q.isEmpty()) {
            sum += q.poll();
        }
        return sum;
    }
}