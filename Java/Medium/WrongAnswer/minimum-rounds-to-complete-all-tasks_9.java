class Solution {
    public int minimumRounds(int[] tasks) {
        
        int n = tasks.length;
        if (n == 1) return (tasks[0] + 1) / 2;
        Arrays.sort(tasks);
        int[] count = new int[1000001];
        int max = 0;
        for (int t : tasks) {
            count[t]++;
            max = Math.max(max, t);
        }
        int res = 0;
        int i = 1;
        while (i <= max) {
            if (count[i] == 0) {
                i++;
                continue;
            }
            if (count[i] % 2 == 1) {
                count[i + 1]++;
                res++;
            }
            count[i + 2] += count[i] / 2;
            i++;
        }
        while (i <= 1000000) {
            if (count[i] > 0) {
                res += (count[i] + 1) / 2;
            }
            i++;
        }
        return res;
    }
}