class Solution {
    public int minimumEffort(int[][] tasks) {
        
        int res = 0;
        int n = tasks.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            res += tasks[i][0];
            diff[i] = tasks[i][1] - tasks[i][0];
        }
        Arrays.sort(diff);
        for (int i = n-1; i >= 0; i--) {
            if (diff[i] > 0) {
                res += diff[i];
            } else {
                break;
            }
        }
        return res;
    }
}