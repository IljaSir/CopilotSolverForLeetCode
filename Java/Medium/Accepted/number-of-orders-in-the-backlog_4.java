class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        
        PriorityQueue<int[]> buy = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];
            if (type == 0) {
                while (amount > 0 && !sell.isEmpty() && sell.peek()[0] <= price) {
                    int[] sellOrder = sell.poll();
                    if (sellOrder[1] > amount) {
                        sellOrder[1] -= amount;
                        sell.offer(sellOrder);
                        amount = 0;
                    } else {
                        amount -= sellOrder[1];
                    }
                }
                if (amount > 0) {
                    buy.offer(new int[] { price, amount });
                }
            } else {
                while (amount > 0 && !buy.isEmpty() && buy.peek()[0] >= price) {
                    int[] buyOrder = buy.poll();
                    if (buyOrder[1] > amount) {
                        buyOrder[1] -= amount;
                        buy.offer(buyOrder);
                        amount = 0;
                    } else {
                        amount -= buyOrder[1];
                    }
                }
                if (amount > 0) {
                    sell.offer(new int[] { price, amount });
                }
            }
        }
        int ans = 0;
        while (!buy.isEmpty()) {
            ans += buy.poll()[1];
            ans %= 1000000007;
        }
        while (!sell.isEmpty()) {
            ans += sell.poll()[1];
            ans %= 1000000007;
        }
        return ans;
    }
}