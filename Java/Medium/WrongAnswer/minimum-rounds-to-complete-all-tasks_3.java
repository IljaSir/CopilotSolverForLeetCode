class Solution {
    public int minimumRounds(int[] tasks) {
        
        int n = tasks.length;
        int[] count = new int[10];
        for (int task : tasks) {
            int i = (int) (Math.log(task - 1) / Math.log(2)) + 1;
            count[i]++;
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i] > 0) {
                ans += count[i] / 2;
                if (count[i] % 2 == 1) {
                    ans++;
                    count[i + 1]++;
                }
            }
        }
        return ans;
    }
}