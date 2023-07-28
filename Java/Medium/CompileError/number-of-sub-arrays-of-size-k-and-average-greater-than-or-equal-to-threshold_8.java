class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int result = 0;
        if (sum >= threshold * k) {
            result++;
        }
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            if (sum >= threshold * k) {
                result++;
            }
        } threshold) {
                count++;
            }
        }
        return count;
    }
}