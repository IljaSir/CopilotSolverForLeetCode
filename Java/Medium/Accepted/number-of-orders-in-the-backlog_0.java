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
                    sellOrder[1] = 0;
                    buy.offer(buyOrder);
                } else if (buyOrder[1] < sellOrder[1]) {
                    sellOrder[1] -= buyOrder[1];
                    buyOrder[1] = 0;
                    sell.offer(sellOrder);
                }
            }
        }
        int res = 0;
        while (!buy.isEmpty()) {
            res = (res + buy.poll()[1]) % 1000000007;
        }
        while (!sell.isEmpty()) {
            res = (res + sell.poll()[1]) % 1000000007;
        }
        return res;
    }
}