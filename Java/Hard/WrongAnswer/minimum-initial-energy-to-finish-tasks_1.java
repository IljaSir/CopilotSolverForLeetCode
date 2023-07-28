class Solution {
    public int minimumEffort(int[][] tasks) {
        
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int res = 0;
        for (int[] task : tasks) {
            res = Math.max(res + task[0], task[1]);
        }
        return res;
    }
}