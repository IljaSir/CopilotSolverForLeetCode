class Solution {
    public int minimumRounds(int[] tasks) {
        
        int n = tasks.length;
        int[] cnt = new int[1000010];
        for (int i = 0; i < n; i++) {
            int t = (tasks[i] + 1) / 2;
            cnt[t]++;
        }
        int res = 0;
        for (int i = 0; i <= 1000000; i++) {
            if (cnt[i] == 0) continue;
            if (cnt[i] % 2 == 1) {
                cnt[i]--;
                res++;
            }
            if (i <= 1000000 - 2) {
                cnt[i + 2] += cnt[i] / 2;
            } else {
                res += cnt[i] / 2;
            }
        }
        return res;
    }
}