class Solution {
    public double trimMean(int[] arr) {
        
        Arrays.sort(arr);
        int len = arr.length;
        double sum = 0;
        for (int i = len / 20; i < len - len / 20; i++) {
            sum += arr[i];
        }
        return sum / (len - len / 10);
    }
}