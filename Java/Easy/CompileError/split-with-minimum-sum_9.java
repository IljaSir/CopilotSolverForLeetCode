class Solution {
    public int splitNum(int num) {
        
        int[] counts = new int[10];
        while (num > 0) {
            counts[num % 10]++;
            num /= 10;
        }
        int[] dp = new int[1 << 10];
        for (int i = 1; i < dp.length; i++) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += counts[j];
                }
            }
            dp[i] = sum;
        }
        int[] min = new int[1 << 10];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) != 0) {
                    int prev = i - (1 << j);
                    min[i] = Math.min(min[i], min[prev] + dp[prev] * j);
                }
            }
        }
        return min[dp.length - 1];
    }
    public int splitNum1(int num) {
        int[] counts = new int[10];
        while (num > 0) {
            counts[num % 10]++;
            num /= 10;
        }
        int[] dp = new int[1 << 10];
        for (int i = 1; i < dp.length; i++) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += counts[j];
                }
            }
            dp[i] = sum;
        }
        int[] min = new int[1 << 10];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) != 0) {
                    int prev = i - (1 << j);
                    min[i] = Math.min(min[i], min[prev] + dp[prev] * j);
    }
}