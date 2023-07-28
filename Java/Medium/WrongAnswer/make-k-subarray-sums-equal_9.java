class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        
        long ans=0;
        int n=arr.length;
        long[] prefix=new long[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        long sum=prefix[k-1];
        for(int i=0;i<n;i++){
            int j=(i+k)%n;
            long curr=sum;
            if(i>0){
                curr=curr-prefix[i-1];
            }
            if(j>0){
                curr=curr+prefix[j-1];
            }
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}