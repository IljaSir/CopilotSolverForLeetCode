class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int max = arr[0];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (max == i) {
                count++;
            }
        }
        return count;
    }
}