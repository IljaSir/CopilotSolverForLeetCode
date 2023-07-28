class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j += 2) {
                res += prefixSum[j + 1] - prefixSum[i];
            }
        }
        return res;
    }
}