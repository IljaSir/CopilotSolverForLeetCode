class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        
        final int N = 100000;
        int[] freq = new int[N + 1];
        for (int n : nums) {
            freq[n]++;
        }
        long[] prefixSum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + freq[i];
        }
        List<Long> res = new ArrayList<>();
        for (int q : queries) {
            long sum = 0;
            for (int i = 1; i <= N; i++) {
                if (i > q) {
                    sum += (long) (i - q) * freq[i];
                } else {
                    sum += (long) (q - i) * (prefixSum[q] - prefixSum[i - 1]);
                }
            }
            res.add(sum);
        }
        return res;
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