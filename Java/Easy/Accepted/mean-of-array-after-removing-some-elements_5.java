class Solution {
    public double trimMean(int[] arr) {
        
        Arrays.sort(arr);
        int n = arr.length;
        int removed = n / 20;
        double sum = 0;
        for (int i = removed; i < n - removed; i++) {
            sum += arr[i];
        }
        return sum / (n - 2 * removed);
    }
}