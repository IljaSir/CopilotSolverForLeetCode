class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        
        long sum = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            min = Math.min(min, sum);
        }
        long result = 0;
        long[] preSum = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            preSum[i] = sum;
            sum -= arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            result += Math.abs(preSum[i] - (min + (long)k * i));
        }
        return result;
    }
}