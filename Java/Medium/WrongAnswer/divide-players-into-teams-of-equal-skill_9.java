class Solution {
    public long dividePlayers(int[] skill) {
        
        int n = skill.length;
        int[] sum = new int[n / 2];
        int[] count = new int[n / 2];
        for (int i = 0; i < n; i++) {
            sum[i % (n / 2)] += skill[i];
            count[i % (n / 2)]++;
        }
        for (int i = 0; i < n / 2; i++) {
            if (count[i] != 2) {
                return -1;
            }
        }
        long ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += (long) sum[i] * sum[i];
        }
        return ans;
    }
}