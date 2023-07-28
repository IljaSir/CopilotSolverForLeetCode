class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        
        int mod = 1000000007;
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] order : orders) {
            int price = order[0], amount = order[1], type = order[2];
            if (type == 0) {
                while (amount > 0 && !sell.isEmpty() && sell.peek()[0] <= price) {
                    int[] sellOrder = sell.poll();
                    if (amount >= sellOrder[1]) {
                        amount -= sellOrder[1];
                    } else {
                        sellOrder[1] -= amount;
                        amount = 0;
                        sell.offer(sellOrder);
                    }
                }
                if (amount > 0) {
                    buy.offer(new int[]{price, amount});
                }
            } else {
                while (amount > 0 && !buy.isEmpty() && buy.peek()[0] >= price) {
                    int[] buyOrder = buy.poll();
                    if (amount >= buyOrder[1]) {
                        amount -= buyOrder[1];
                    } else {
                        buyOrder[1] -= amount;
                        amount = 0;
                        buy.offer(buyOrder);
                    }
                }
                if (amount > 0) {
                    sell.offer(new int[]{price, amount});
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