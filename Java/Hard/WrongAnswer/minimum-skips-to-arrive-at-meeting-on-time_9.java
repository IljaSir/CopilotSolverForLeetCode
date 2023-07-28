class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        
        int n = dist.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            dp[i] = (int)Math.ceil((double)dist[i-1]/speed);
        }
        for(int i=0; i<n; i++){
            for(int j=n; j>0; j--){
                dp[j] = Math.min(dp[j], dp[j-1] + (int)Math.ceil((double)dist[i]/speed));
            }
            for(int j=1; j<=n; j++){
                dp[j] = Math.min(dp[j], dp[j-1] + (int)Math.ceil((double)dist[i]/speed));
            }
        }
        for(int i=0; i<=n; i++){
            if(dp[i] <= hoursBefore*speed){
                return i;
            }
        }
        return -1;
    }
}