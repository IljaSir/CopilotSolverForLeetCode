class Solution {
    public double trimMean(int[] arr) {
        
        Arrays.sort(arr);
        int n = arr.length;
        int start = n / 20;
        int end = n - start;
        double sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum / (n - 2 * start);
    }
}