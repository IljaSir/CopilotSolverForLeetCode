class Solution {
    public int maxProduct(String s) {
        
        int n=s.length();
        int[] dp=new int[1<<n];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int mask=0;mask<(1<<n);mask++){
            int count=Integer.bitCount(mask);
            if(dp[mask]==-1) continue;
            for(int i=0;i<n;i++){
                if((mask&(1<<i))==0){
                    dp[mask|(1<<i)]=Math.max(dp[mask|(1<<i)],dp[mask]+(isPalindrome(s,mask,count)?count+1:0));
                }
            }
        }
        int ans=0;
        for(int mask=0;mask<(1<<n);mask++){
            ans=Math.max(ans,dp[mask]*dp[(1<<n)-1-mask]);
        }
        return ans;
    }
    boolean isPalindrome(String s,int mask,int count){
        int i=0,j=count-1;
        while(i<j){
            while(i<count && (mask&(1<<i))==0) i++;
            while(j>=0 && (mask&(1<<j))==0) j--;
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}