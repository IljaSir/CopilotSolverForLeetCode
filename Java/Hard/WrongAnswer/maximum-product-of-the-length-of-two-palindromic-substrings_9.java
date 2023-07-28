class Solution {
    public long maxProduct(String s) {
        
        int n = s.length();
        int[] dp = new int[1<<n];
        for(int i=0; i<1<<n; i++){
            int left = 0;
            int right = n-1;
            while(left<right){
                if(((i>>left)&1)==1 && ((i>>right)&1)==1){
                    if(s.charAt(left)!=s.charAt(right)) break;
                }
                left++;
                right--;
            }
            if(left>=right) dp[i] = Integer.bitCount(i);
        }
        long ans = 0;
        for(int i=0; i<1<<n; i++){
            ans = Math.max(ans, (long)dp[i]*dp[(1<<n)-1-i]);
        }
        return ans;
    }
}