class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        
        int n = floor.length();
        int[] dp = new int[n];
        int[] presum = new int[n];
        int[] sum = new int[n];
        int[] last = new int[n];
        int[] next = new int[n];
        int[] count = new int[n];
        Arrays.fill(last, -1);
        Arrays.fill(next, n);
        int c = 0;
        for(int i = 0; i < n; i++){
            if(floor.charAt(i) == '1'){
                c++;
                presum[i] = 1;
            }
            if(i > 0){
                presum[i] += presum[i - 1];
            }
        }
        for(int i = n - 1; i >= 0; i--){
            if(floor.charAt(i) == '1'){
                count[i] = 1;
            }
            if(i < n - 1){
                count[i] += count[i + 1];
            }
        }
        for(int i = 0; i < n; i++){
            if(floor.charAt(i) == '0'){
                if(i > 0){
                    last[i] = last[i - 1];
                }
                last[i] = i;
            }
        }
        for(int i = n - 1; i >= 0; i--){
            if(floor.charAt(i) == '0'){
                if(i < n - 1){
                    next[i] = next[i + 1];
                }
                next[i] = i;
            }
        }
        for(int i = 0; i < n; i++){
            int l = last[i];
            int r = next[i];
            if(l == -1){
                l = i;
            }
            if(r == n){
                r = i;
            }
            sum[i] = presum[r] - (l > 0 ? presum[l - 1] : 0);
        }
        for(int i = 0; i < n; i++){
            dp[i] = count[i];
        }
        for(int i = 1; i < numCarpets; i++){
            int[] cur = new int[n];
            int[] left = new int[n];
            int[] right = new int[n];
            for(int j = 0; j < n; j++){
                left[j] = j;
                if(j > 0 && floor.charAt(j
    }
}