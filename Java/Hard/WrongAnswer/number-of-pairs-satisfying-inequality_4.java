class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        
        int n = nums1.length;
        long ans = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (nums1[i] - nums2[j] <= diff) {
                ans += j;
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}