class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        int count = 0;
        for (int i = 0; i <= n - k; i++) {
            if ((prefix[i + k] - prefix[i]) / k >= threshold) {
                count++;
            }
        }
        return count;
    }
}