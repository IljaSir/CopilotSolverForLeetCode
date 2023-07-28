class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length;
        int m = workers.length;
        int j = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (j < m && workers[j] < tasks[i]) {
                j++;
            }
            if (j < m) {
                res++;
                j++;
            } else {
                if (pills > 0) {
                    pills--;
                    res++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}