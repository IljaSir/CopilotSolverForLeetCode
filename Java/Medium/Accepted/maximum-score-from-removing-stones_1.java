class Solution {
    public int maximumScore(int a, int b, int c) {
        
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        if (arr[2] >= arr[0] + arr[1] + 1) {
            return arr[0] + arr[1];
        }
        return (arr[0] + arr[1] + arr[2]) / 2;
    }
}