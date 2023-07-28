class Solution {
    public int maximumScore(int a, int b, int c) {
        
        int[] arr = new int[] {a, b, c};
        Arrays.sort(arr);
        int max = arr[2];
        int min = arr[0];
        int mid = arr[1];
        
        if (min + mid <= max) {
            return min + mid;
        } else {
            return (min + mid + max) / 2;
        }
    }
}