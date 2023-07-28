class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        
        int n = nums.length;
        int m = queries.length;
        int[] cnt = new int[100001];
        for (int num : nums) {
            cnt[num]++;
        }
        int[] sum = new int[100001];
        for (int i = 1; i <= 100000; i++) {
            sum[i] = sum[i - 1] + cnt[i];
        }
        List<Long> ans = new ArrayList<>();
        for (int query : queries) {
            long res = 2;
            for (int i = 1; i <= 100000; i++) {
                if (i == query) {
                    continue;
                }
                if (i < query) {
                    res += 1L * (sum[query - 1] - sum[i]) * (query - i);
                } else {
                    res += 1L * (sum[i - 1] - sum[query]) * (i - query);
                }
            }
            ans.add(res);
        }
        return ans;
    }
}