class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
        for(int i=0;i<piles.length;i++){
            pq.add(piles[i]);
            sum += piles[i];
        }
        for(int i=0;i<k;i++){
            int val = pq.poll();
            int diff = val/2;
            sum -= diff;
            pq.add(val-diff);
        }
        return sum;
    }
}