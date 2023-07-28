class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        
        long[] sum = new long[arr.length];
        sum[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            sum[i] = sum[i-1] + arr[i];
        }
        long[] modSum = new long[arr.length];
        for(int i = 0; i < arr.length; i++){
            modSum[i] = sum[i] % k;
        }
        long ans = modSum[0];
        long[] map = new long[k];
        map[(int)modSum[0]]++;
        for(int i = 1; i < arr.length; i++){
            ans += map[(int)modSum[i]];
            map[(int)modSum[i]]++;
        }
        return ans;
    }
}