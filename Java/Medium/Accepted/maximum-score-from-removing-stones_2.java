class Solution {
    public int maximumScore(int a, int b, int c) {
        
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        int sum = arr[0] + arr[1] + arr[2];
        return Math.min(sum / 2, arr[0] + arr[1]);
    }
}