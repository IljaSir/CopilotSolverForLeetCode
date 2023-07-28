class Solution {
    public int minOperations(int n) {
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = (2 * i) + 1;
        }
        int target = 0;
        for(int i = 0; i < n; i++) {
            target += arr[i];
        }
        target /= n;
        int count = 0;
        for(int i = 0; i < n / 2; i++) {
            count += target - arr[i];
        }
        return count;
    }
}