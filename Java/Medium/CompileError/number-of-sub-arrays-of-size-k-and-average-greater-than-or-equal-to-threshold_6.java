class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        int count = 0;
        for (int i = k; i <= n; i++) {
            int n = arprefixSum[i] - prefixSum[i - k];
            if (sum >= k * threshold) {
                count++;
            }
        }
        return count;
    }
}