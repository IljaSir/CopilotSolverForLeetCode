class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        int n = nums.length;
        int[] mod = new int[n];
        for (int i = 0; i < n; i++) {
            mod[i] = nums[i] % p;
        }
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = (prefix[i] + mod[i]) % p;
        }
        int[] count = new int[p];
        count[0] = 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int cur = prefix[i];
            int left = Math.max(0, i - k);
            res += count[cur];
            count[cur]++;
            count[prefix[left]]--;
        }
        return res;
    }
}