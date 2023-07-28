class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        
        List<Long> ret = new ArrayList<>();
        int[] cnt = new int[100001];
        for (int num : nums) {
            cnt[num]++;
        }
        long[] sum = new long[100002];
        for (int i = 1; i <= 100000; i++) {
            sum[i] = sum[i - 1] + cnt[i];
        }
        for (int q : queries) {
            long t = 0;
            for (int i = 1; i <= 100000; i++) {
                if (i < q) {
                    t += (q - i) * (sum[i] - sum[i - 1]);
                } else {
                    t += (i - q) * (sum[100000] - sum[i]);
                }
            }
            ret.add(t);
        }
        return ret;
    }
}