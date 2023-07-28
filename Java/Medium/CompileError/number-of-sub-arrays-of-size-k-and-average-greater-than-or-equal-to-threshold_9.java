class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int sum = 0;
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum / k >= threshold) {
            count++;
        }
        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i - k];
            if (sum / k >=
        return result;
    }
}