class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        int n = tasks.length, m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(tasks, workers, pills, strength, mid)) l = mid;
            else r = mid - 1;
        }
        return l + 1;
    }

    public boolean check(int[] tasks, int[] workers, int pills, int strength, int r) {
        int n = tasks.length, m = workers.length;
        int i = 0, j = 0, k = m - 1;
        while (i < n && j <= r) {
            if (tasks[i] <= workers[j] + strength * pills) {
                i++;
            } else if (k > r) {
                k--;
                pills--;
            } else {
                j++;
            }
        }
        return i == n;
    }
}