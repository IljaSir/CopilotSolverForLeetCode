class Solution {
    public int minimumEffort(int[][] tasks) {
        
        Arrays.sort(tasks, (a, b) -> a[1] - a[0] - (b[1] - b[0]));
        int res = 0;
        for (int[] t : tasks) {
            res = Math.max(res + t[0], t[1]);
        }
        return res;
    }
}