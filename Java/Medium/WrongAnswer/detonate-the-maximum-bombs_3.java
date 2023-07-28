class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        int[] x = new int[n];
        int[] y = new int[n];
        int[] r = new int[n];
        for(int i=0;i<n;i++){
            x[i] = bombs[i][0];
            y[i] = bombs[i][1];
            r[i] = bombs[i][2];
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j])<=r[i]*r[i]){
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt+1);
        }
        return ans;
    }
}