class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        
        int n = tasks.length;
        int[] mask = new int[1 << n];
        Arrays.fill(mask, -1);
        mask[0] = 0;
        for (int i = 0; i < (1 << n); ++i) {
            if (mask[i] == -1) {
                continue;
            }
            int timeLeft = sessionTime;
            for (int j = 0; j < n; ++j) {
                if (((i >> j) & 1) == 0) {
                    if (timeLeft >= tasks[j]) {
                        mask[i | (1 << j)] = mask[i];
                        timeLeft -= tasks[j];
                    } else {
                        mask[i | (1 << j)] = mask[i] + 1;
                        timeLeft = sessionTime - tasks[j];
                    }
                }
            }
        }
        return mask[(1 << n) - 1];
    }
}