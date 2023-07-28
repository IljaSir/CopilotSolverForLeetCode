class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        int[] count = new int[n];
        for (int[] meeting : meetings) {
            count[meeting[0]]++;
            count[meeting[1]]--;
        }
        int max = 0, maxIdx = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            cur += count[i];
            if (cur > max) {
                max = cur;
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}