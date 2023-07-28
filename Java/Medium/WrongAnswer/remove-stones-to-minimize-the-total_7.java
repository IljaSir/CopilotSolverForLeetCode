class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int x : piles) {
            pq.add(x);
        }
        while (k > 0) {
            int x = pq.poll();
            int y = (x + 1) / 2;
            x -= y;
            pq.add(x);
            k--;
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}