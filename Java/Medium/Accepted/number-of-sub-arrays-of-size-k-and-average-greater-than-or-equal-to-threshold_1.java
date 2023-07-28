class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int res = sum >= k * threshold ? 1 : 0;
        for (int i = k; i < arr.length; i++) {
            sum = sum - arr[i - k] + arr[i];
            res += sum >= k * threshold ? 1 : 0;
        }
        return res;
    }
}