class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        
        int[] count = new int[100001];
        for (int x: nums) count[x]++;
        int[] prefix = new int[100001];
        for (int i = 1; i <= 100000; i++) prefix[i] = prefix[i-1] + count[i];
        List<Long> res = new ArrayList<>();
        for (int x: queries) {
            int lo = 1, hi = 100000;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (prefix[mid] < x) lo = mid + 1;
                else hi = mid;
            }
            int l = lo;
            lo = 1;
            hi = 100000;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (prefix[mid] <= x) lo = mid + 1;
                else hi = mid;
            }
            int r = lo;
            long ans = 0;
            for (int i = l; i <= r; i++) {
                ans += (long)count[i] * Math.abs(i - x);
            }
            res.add(ans);
        }
        return res;
    }
}