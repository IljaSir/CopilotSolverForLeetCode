class Solution {
    public int maximumScore(int a, int b, int c) {
        
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int min = arr[0];
        int mid = arr[1];
        int max = arr[2];
        
        if (min + mid <= max) {
            return min + mid;
        }
        return (min + mid + max) / 2;
    }
}