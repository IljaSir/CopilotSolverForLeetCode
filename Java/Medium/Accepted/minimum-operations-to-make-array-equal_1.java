class Solution {
    public int minOperations(int n) {
        
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = (2 * i) + 1;
            sum += arr[i];
        }
        int avg = sum / n;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > avg) {
                count += arr[i] - avg;
            }
        }
        return count;
    }
}