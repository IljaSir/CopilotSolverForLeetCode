class Solution {
    public int maxJumps(int[] arr, int d) {
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] index = new int[n];
        for(int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> {
            return arr[a] - arr[b];
        });
        for(int i = 0; i < n; i++) {
            int cur = index[i];
            for(int j = cur + 1; j <= cur + d && j < n; j++) {
                if(arr[j] >= arr[cur]) {
                    break;
                }
                dp[cur] = Math.max(dp[cur], dp[j] + 1);
            }
            for(int j = cur - 1; j >= cur - d && j >= 0; j--) {
                if(arr[j] >= arr[cur]) {
                    break;
                }
                dp[cur] = Math.max(dp[cur], dp[j] + 1);
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}