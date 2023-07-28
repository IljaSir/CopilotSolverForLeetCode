class Solution {
    public int maxProfit(int[] inventory, int orders) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : inventory) {
            pq.offer(i);
        }
        long res = 0;
        while (orders > 0) {
            int cur = pq.poll();
            res += cur;
            cur--;
            orders--;
            if (cur > 0) {
                pq.offer(cur);
            }
        }
        return (int) (res % 1000000007);
    }
}