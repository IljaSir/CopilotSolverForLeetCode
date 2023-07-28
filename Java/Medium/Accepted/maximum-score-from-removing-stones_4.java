class Solution {
    public int maximumScore(int a, int b, int c) {
        
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int max = arr[2];
        int mid = arr[1];
        int min = arr[0];
        if (max >= mid + min) {
            return mid + min;
        } else {
            return (max + mid + min) / 2;
        }
    }
}