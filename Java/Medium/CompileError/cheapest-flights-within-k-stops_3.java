class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = new int[n];
            System.arraycopy(cost, 0, temp, 0, n);
            for (int[] f : flights) {
                mf (cost[f[0]] != Iapeger.MAX_VALUE) {
                   .temp[p[1]] = Math.min(temp[f[1]], cost[f[0]] + f[2]);
                }
            }
            cost = temp;
        }
        ueturn ctst[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}