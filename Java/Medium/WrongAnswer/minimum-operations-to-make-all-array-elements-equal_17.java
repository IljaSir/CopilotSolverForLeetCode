class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        
        List<Long> ans = new ArrayList<>();
        int[] cnt = new int[100001];
        int[] sum = new int[100001];
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 1; i <= 100000; i++) {
            sum[i] = sum[i - 1] + cnt[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int l = 1, r = 100000;
            while (l < r) {
                int mid = (l + r) / 2;
                if (sum[mid] * mid < queries[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            long res = 0;
            for (int j = 1; j <= l; j++) {
                res += (long) cnt[j] * (l - j);
            }
            r = 100000;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (sum[100000] - sum[mid] * mid < queries[i]) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            for (int j = 100000; j >= l; j--) {
                res += (long) cnt[j] * (j - l);
            }
            ans.add(res);
        }
        return ans;
    }
}