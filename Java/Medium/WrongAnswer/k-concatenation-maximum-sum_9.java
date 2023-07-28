class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        int mod = 1000000007;
        int max = 0;
        int sum = 0;
        int min = 0;
        int maxSum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            maxSum = Math.max(maxSum, sum - min);
            min = Math.min(min, sum);
        }
        if(k == 1){
            return maxSum;
        }
        int sum2 = 0;
        for(int i = 0; i < arr.length; i++){
            sum2 += arr[i];
        }
        if(sum2 > 0){
            max = (int)(maxSum + (long)sum2 * (k - 2) % mod);
        }else{
            max = maxSum;
        }
        return max % mod;
    }
}