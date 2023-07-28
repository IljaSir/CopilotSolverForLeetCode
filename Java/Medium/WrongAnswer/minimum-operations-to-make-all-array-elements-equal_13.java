class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        
        int n = nums.length;
        int m = queries.length;
        int[] cnt = new int[100001];
        for (int num : nums) {
            cnt[num]++;
        }
        int[] preSum = new int[100001];
        for (int i = 1; i <= 100000; i++) {
            preSum[i] = preSum[i - 1] + cnt[i];
        }
        List<Long> ans = new ArrayList<>();
        for (int query : queries) {
            int l = 0, r = 100000;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (preSum[mid] < query) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int t = l;
            long res = 0;
            for (int i = 1; i <= 100000; i++) {
                if (i < t) {
                    res += (long) (t - i) * cnt[i];
                } else if (i > t) {
                    res += (long) (i - t) * cnt[i];
                }
            }
            ans.add(res);
        }
        return ans;
    }
}