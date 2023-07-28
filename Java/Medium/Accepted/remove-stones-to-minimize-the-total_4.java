class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int pile : piles) {
            pq.offer(pile);
            sum += pile;
        }
        while (k > 0) {
            int pile = pq.poll();
            sum -= pile / 2;
            pq.offer(pile - pile / 2);
            k--;
        }
        return sum;
    }
}