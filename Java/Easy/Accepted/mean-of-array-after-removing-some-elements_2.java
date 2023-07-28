class Solution {
    public double trimMean(int[] arr) {
        
        int n = arr.length;
        int k = n / 20;
        Arrays.sort(arr);
        double sum = 0;
        for (int i = k; i < n - k; i++) {
            sum += arr[i];
        }
        return sum / (n - 2 * k);
    }
}