class Solution {
    public int maxProfit(int[] inventory, int orders) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int i : inventory) {
            pq.add(i);
        }
        long res = 0;
        while (orders > 0) {
            int cur = pq.poll();
            orders--;
            res += cur;
            pq.add(cur - 1);
        }
        return (int) (res % 1000000007);
    }
}