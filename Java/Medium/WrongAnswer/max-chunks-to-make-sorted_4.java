class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int[] min = new int[arr.length];
        min[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            min[i] = Math.min(arr[i], min[i + 1]);
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max <= min[i]) {
                count++;
            }
        }
        return count;
    }
}