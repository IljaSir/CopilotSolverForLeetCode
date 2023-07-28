class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int[] max = new int[arr.length];
        int[] min = new int[arr.length];
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxNum = Math.max(maxNum, arr[i]);
            max[i] = maxNum;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            minNum = Math.min(minNum, arr[i]);
            min[i] = minNum;
        }
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max[i] == min[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}