class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        int[] times = new int[500001];
        for (int[] meeting : meetings) {
            times[meeting[0]]++;
            times[meeting[1]]--;
        }
        int max = 0;
        int ans = 0;
        int count = 0;
        for (int i = 0; i < times.length; i++) {
            count += times[i];
            if (max < count) {
                max = count;
                ans = i;
            }
        }
        return ans;
    }
}