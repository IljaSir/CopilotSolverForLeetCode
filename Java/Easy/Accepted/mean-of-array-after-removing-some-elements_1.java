class Solution {
    public double trimMean(int[] arr) {
        
        int n = arr.length;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = n / 20; i < n - n / 20; i++) {
            sum += arr[i];
        }
        return (double) sum / (n - n / 10);
    }
}