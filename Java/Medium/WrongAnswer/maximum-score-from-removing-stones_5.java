class Solution {
    public int maximumScore(int a, int b, int c) {
        
        int[] arr = new int[] {a, b, c};
        Arrays.sort(arr);
        int sum = arr[0] + arr[1] + arr[2];
        if (sum - arr[2] >= arr[2]) {
            return arr[2];
        } else {
            return (sum - arr[2]) + (arr[2] - (sum - arr[2])) / 2;
        }
    }
}