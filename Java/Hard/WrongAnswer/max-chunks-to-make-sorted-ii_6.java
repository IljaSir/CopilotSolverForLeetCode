class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int[] max = new int[arr.length];
        int[] min = new int[arr.length];
        max[0] = arr[0];
        min[arr.length-1] = arr[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            max[i] = Math.max(max[i-1], arr[i]);
            min[arr.length-1-i] = Math.min(min[arr.length-i], arr[arr.length-1-i]);
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (max[i] <= min[i+1]) count++;
                continue;
            }
            if (i == arr.length-1) {
                if (min[i] >= max[i-1]) count++;
                continue;
            }
            if (max[i] <= min[i+1] && min[i] >= max[i-1]) count++;
        }
        return count;
    }
}