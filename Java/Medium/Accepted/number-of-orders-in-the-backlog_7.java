class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        
        PriorityQueue<int[]> buy = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        PriorityQueue<int[]> sell = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for (int[] order : orders) {
            if (order[2] == 0) {
                while (order[1] > 0 && !sell.isEmpty() && sell.peek()[0] <= order[0]) {
                    int[] s = sell.poll();
                    if (s[1] > order[1]) {
                        s[1] -= order[1];
                        sell.offer(s);
                        order[1] = 0;
                    } else {
                        order[1] -= s[1];
                    }
                }
                if (order[1] > 0) buy.offer(order);
            } else {
                while (order[1] > 0 && !buy.isEmpty() && buy.peek()[0] >= order[0]) {
                    int[] b = buy.poll();
                    if (b[1] > order[1]) {
                        b[1] -= order[1];
                        buy.offer(b);
                        order[1] = 0;
                    } else {
                        order[1] -= b[1];
                    }
                }
                if (order[1] > 0) sell.offer(order);
            }
        }
        int res = 0;
        for (int[] b : buy) res = (res + b[1]) % 1000000007;
        for (int[] s : sell) res = (res + s[1]) % 1000000007;
        return res;
    }
}