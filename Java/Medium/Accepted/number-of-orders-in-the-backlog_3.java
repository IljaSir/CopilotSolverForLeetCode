class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] order : orders) {
            if (order[2] == 0) {
                buy.offer(order);
            } else {
                sell.offer(order);
            }
            while (!buy.isEmpty() && !sell.isEmpty() && buy.peek()[0] >= sell.peek()[0]) {
                int[] buyOrder = buy.poll();
                int[] sellOrder = sell.poll();
                if (buyOrder[1] > sellOrder[1]) {
                    buyOrder[1] -= sellOrder[1];
                    buy.offer(buyOrder);
                } else if (buyOrder[1] < sellOrder[1]) {
                    sellOrder[1] -= buyOrder[1];
                    sell.offer(sellOrder);
                }
            }
        }
        int res = 0;
        while (!buy.isEmpty()) {
            res += buy.peek()[1];
            res %= 1_000_000_007;
            buy.poll();
        }
        while (!sell.isEmpty()) {
            res += sell.peek()[1];
            res %= 1_000_000_007;
            sell.poll();
        }
        return res;
    }
}