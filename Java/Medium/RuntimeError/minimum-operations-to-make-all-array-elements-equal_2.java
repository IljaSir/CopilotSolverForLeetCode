class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        
        int[] cnt = new int[100001];
        for (int n : nums) cnt[n]++;
        int[] sum = new int[100001];
        for (int i = 1; i <= 100000; i++) {
            sum[i] = sum[i - 1] + cnt[i];
        }
        List<Long> res = new ArrayList<>();
        for (int q : queries) {
            int l = 1, r = 100000;
            while (l < r) {
                int mid = (l + r) / 2;
                if (sum[mid] < q) l = mid + 1;
                else r = mid;
            }
            long ans = 0;
            int i = l;
            while (q > 0) {
                int c = Math.min(cnt[i], q);
                ans += (long) c * Math.abs(i - l);
                q -= c;
                i++;
            }
            i = l - 1;
            while (q < 0) {
                int c = Math.min(cnt[i], -q);
                ans += (long) c * Math.abs(i - l);
                q += c;
                i--;
            }
            res.add(ans);
        }
        return res;
    }
}