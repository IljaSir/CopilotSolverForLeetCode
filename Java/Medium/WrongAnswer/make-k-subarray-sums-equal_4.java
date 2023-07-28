class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        
        int n = arr.length;
        long[] sum = new long[n];
        sum[0] = arr[0];
        for(int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + arr[i];
        }
        long[] sub = new long[n];
        for(int i = 0; i < n; i++) {
            sub[i] = sum[(i+k-1)%n] - (i == 0 ? 0 : sum[i-1]);
        }
        long[] diff = new long[n];
        for(int i = 0; i < n; i++) {
            diff[i] = sub[i] - sub[(i+1)%n];
        }
        long res = 0;
        for(int i = 0; i < n; i++) {
            res += Math.abs(diff[i]);
        }
        return res/2;
    }
}