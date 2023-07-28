class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        
        int n = nums.length;
        int m = queries.length;
        int[] cnt = new int[100001];
        for (int num : nums) {
            cnt[num]++;
        }
        int[] sum = new int[100002];
        for (int i = 1; i <= 100001; i++) {
            sum[i] = sum[i - 1] + cnt[i];
        }
        List<Long> ans = new ArrayList<>();
        for (int q : queries) {
            int l = 1;
            int r = 100001;
            while (l < r) {
                int mid = l + r >> 1;
                if (sum[mid] < q) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            long res = 0;
            for (int i = 1; i <= l; i++) {
                res += (long) (l - i) * cnt[i];
            }
            for (int i = l + 1; i <= 100001; i++) {
                res += (long) (i - l) * cnt[i];
            }
            ans.add(res);
        }
        return ans;
    }
}