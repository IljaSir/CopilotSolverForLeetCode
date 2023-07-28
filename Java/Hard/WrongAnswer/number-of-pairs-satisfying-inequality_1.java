class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        
        int n = nums1.length;
        int[] cnt = new int[20001];
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += cnt[nums1[i] - nums2[i] + 10000 + diff];
            cnt[nums1[i] - nums2[i] + 10000]++;
        }
        return res;
    }
}