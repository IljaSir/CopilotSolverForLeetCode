class Solution {
    public int maximumScore(int a, int b, int c) {
        
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        return Math.min((arr[0] + arr[1] + arr[2]) / 2, arr[0] + arr[1]);
    }
}