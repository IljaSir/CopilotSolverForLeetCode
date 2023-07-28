class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        
        int n = nums1.length;
        long res = 0;
        int[] cnt = new int[20001];
        for (int i = 0; i < n; ++i) {
            res += cnt[nums1[i] - nums2[i] + 10000];
            cnt[nums1[i] - nums2[i] - diff + 10000]++;
        }
        return res;
    }
}