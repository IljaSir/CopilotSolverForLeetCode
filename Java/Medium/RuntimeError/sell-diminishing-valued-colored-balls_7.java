class Solution {
    public int maxProfit(int[] inventory, int orders) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i: inventory) {
            pq.offer(i);
        }
        long ans = 0;
        int mod = 1000000007;
        while (orders > 0) {
            int cur = pq.poll();
            int next = pq.peek();
            if (cur == next || orders <= pq.size()) {
                ans += (long)cur * orders;
                ans %= mod;
                break;
            } else {
                int count = cur - next;
                if (count * pq.size() <= orders) {
                    ans += (long)(cur + next + 1) * count / 2 * pq.size();
                    ans %= mod;
                    orders -= count * pq.size();
                } else {
                    int div = orders / pq.size();
                    int modu = orders % pq.size();
                    ans += (long)(cur + cur - div + 1) * div / 2 * pq.size();
                    ans %= mod;
                    ans += (long)(cur - div) * modu;
                    ans %= mod;
                    break;
                }
            }
        }
        return (int)ans;
    }
}