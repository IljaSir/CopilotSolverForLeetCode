class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        
        int mod = 1000000007;
        PriorityQueue<int[]> buy = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (int[] order : orders) {
            if (order[2] == 0) {
                while (!sell.isEmpty() && sell.peek()[0] <= order[0] && order[1] > 0) {
                    int[] o = sell.poll();
                    if (o[1] > order[1]) {
                        o[1] -= order[1];
                        sell.offer(o);
                        order[1] = 0;
                    } else {
                        order[1] -= o[1];
                    }
                }
                if (order[1] > 0) {
                    buy.offer(order);
                }
            } else {
                while (!buy.isEmpty() && buy.peek()[0] >= order[0] && order[1] > 0) {
                    int[] o = buy.poll();
                    if (o[1] > order[1]) {
                        o[1] -= order[1];
                        buy.offer(o);
                        order[1] = 0;
                    } else {
                        order[1] -= o[1];
                    }
                }
                if (order[1] > 0) {
                    sell.offer(order);
                }
            }
        }
        int ans = 0;
        while (!buy.isEmpty()) {
            ans = (ans + buy.poll()[1]) % mod;
        }
        while (!sell.isEmpty()) {
            ans = (ans + sell.poll()[1]) % mod;
        }
        return ans;
    }
}