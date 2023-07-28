class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        
        int n = boxes.length;
        int[] dp = new int[n + 1];
        int[] next = new int[n];
        int j = n;
        int weight = 0;
        for (int i = n - 1; i >= 0; i--) {
            weight += boxes[i][1];
            while (j > i && (j - i > maxBoxes || weight > maxWeight)) {
                weight -= boxes[--j][1];
            }
            next[i] = j;
        }
        int port = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (port < i && next[port] <= i) {
                port++;
            }
            dp[i] = dp[next[i]] + 1 + (i == port ? 1 : 0);
        }
        return dp[0];
    }
}