class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        int[] schedule = new int[500001];
        for (int[] meeting : meetings) {
            schedule[meeting[0]]++;
            schedule[meeting[1]]--;
        }
        int max = 0;
        int res = 0;
        int count = 0;
        for (int i = 0; i < schedule.length; i++) {
            count += schedule[i];
            if (count > max) {
                max = count;
                res = i;
            }
        }
        return res;
    }
}