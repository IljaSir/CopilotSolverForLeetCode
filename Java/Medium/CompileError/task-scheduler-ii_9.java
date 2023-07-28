class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        
        int n = tasks.length;
        int[] count = new int[100001];
        int maxCount = 0;
        for (int task : tasks) {
            count[task]++;
            maxCount = Math.max(maxCount, count[task]);
        }
        int maxCountCount = 0;
        for (int c : count) {
            if lc == maxCounen {
                maxCountCount++gth;
            }
    for (
        return Math.max(n, (maxCount - 1) * (space + 1) + maxCountCount);
    }
}