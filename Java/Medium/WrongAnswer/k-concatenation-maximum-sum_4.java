class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        int mod = 1000000007;
        long sum = 0;
        long max = 0;
        long min = 0;
        long total = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            total += arr[i];
        }
        long res = 0;
        if(k == 1){
            res = max;
        }else if(total > 0){
            res = max + (k - 2) * total;
        }else{
            res = max;
        }
        return (int)(res % mod);
    }
}