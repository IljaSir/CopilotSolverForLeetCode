class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        
        int n = tasks.length;
        int m = workers.length;
        int[] t = new int[n];
        int[] w = new int[m];
        for (int i = 0; i < n; i++) t[i] = tasks[i];
        for (int i = 0; i < m; i++) w[i] = workers[i];
        Arrays.sort(t);
        Arrays.sort(w);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < m && w[j] < t[i]) j++;
            if (j == m) break;
            w[j] += strength;
            if (pills > 0) {
                pills--;
                w[j] += strength;
            }
            ans++;
        }
        return ans;
    }
}
    }
}