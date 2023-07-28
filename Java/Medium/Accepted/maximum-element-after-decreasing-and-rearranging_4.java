class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        
        Arrays.sort(arr);
        int len = arr.length;
        arr[0] = 1;
        for (int i = 1; i < len; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[len - 1];
    }
}