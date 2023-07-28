class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int max = 0;
        for(int n:nums){
            max = Math.max(max,n);
        }
        int[] dp = new int[max+1];
        for(int n:nums){
            dp[n]++;
        }
        for(int i=2;i<=max;i++){
            for(int j=i+i;j<=max;j+=i){
                dp[i]+=dp[j];
            }
        }
        int res = 0;
        for(int i=1;i<=max;i++){
            if(i%k==0&&dp[i]>0){
                res+=dp[i];
            }
        }
        return res;
    }
}