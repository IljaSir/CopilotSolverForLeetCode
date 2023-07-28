class Solution {
    public double trimMean(int[] arr) {
        
        Arrays.sort(arr);
        int n = arr.length;
        double sum = 0;
        int count = 0;
        for (int i = n / 20; i < n - n / 20; i++) {
            sum += arr[i];
            count++;
        }
        return sum / count;
    }
}