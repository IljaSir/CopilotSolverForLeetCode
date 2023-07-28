class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] order : orders) {
            if (order[2] == 0) {
                while (!sell.isEmpty() && sell.peek()[0] <= order[0] && order[1] > 0) {
                    int[] sellOrder = sell.poll();
                    if (sellOrder[1] > order[1]) {
                        sellOrder[1] -= order[1];
                        order[1] = 0;
                        sell.offer(sellOrder);
                    } else {
                        order[1] -= sellOrder[1];
                    }
                }
                if (order[1] > 0) {
                    buy.offer(order);
                }
            } else {
                while (!buy.isEmpty() && buy.peek()[0] >= order[0] && order[1] > 0) {
                    int[] buyOrder = buy.poll();
                    if (buyOrder[1] > order[1]) {
                        buyOrder[1] -= order[1];
                        order[1] = 0;
                        buy.offer(buyOrder);
                    } else {
                        order[1] -= buyOrder[1];
                    }
                }
                if (order[1] > 0) {
                    sell.offer(order);
                }
            }
        }
        long res = 0;
        while (!buy.isEmpty()) {
            res += buy.poll()[1];
        }
        while (!sell.isEmpty()) {
            res += sell.poll()[1];
        }
        return (int) (res % (1000000007));
    }
}