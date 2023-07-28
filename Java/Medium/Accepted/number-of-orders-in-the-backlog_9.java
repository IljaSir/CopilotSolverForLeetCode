class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        
        final int MOD = 1_000_000_007;
        PriorityQueue<int[]> buy = new PriorityQueue<>((o1, o2) -> o2[0]-o1[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        for (int[] order : orders) {
            int price = order[0], amount = order[1], type = order[2];
            if (type == 0) {
                while (amount > 0 && !sell.isEmpty() && sell.peek()[0] <= price) {
                    int[] o = sell.poll();
                    if (o[1] > amount) {
                        o[1] -= amount;
                        sell.add(o);
                        amount = 0;
                    } else {
                        amount -= o[1];
                    }
                }
                if (amount > 0) {
                    buy.add(new int[]{price, amount});
                }
            } else {
                while (amount > 0 && !buy.isEmpty() && buy.peek()[0] >= price) {
                    int[] o = buy.poll();
                    if (o[1] > amount) {
                        o[1] -= amount;
                        buy.add(o);
                        amount = 0;
                    } else {
                        amount -= o[1];
                    }
                }
                if (amount > 0) {
                    sell.add(new int[]{price, amount});
                }
            }
        }
        long ans = 0;
        for (int[] o : buy) {
            ans += o[1];
            ans %= MOD;
        }
        for (int[] o : sell) {
            ans += o[1];
            ans %= MOD;
        }
        return (int) ans;
    }
}