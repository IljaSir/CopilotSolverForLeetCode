class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        
        int sum1 = 0, sum2 = 0;
        for (int n : nums1) sum1 += n;
        for (int n : nums2) sum2 += n;
        if (sum1 > sum2) return minOperations(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = nums2.length - 1, ans = 0;
        while (sum1 < sum2) {
            int diff1 = i < nums1.length ? 6 - nums1[i] : 0;
            int diff2 = j >= 0 ? nums2[j] - 1 : 0;
            if (diff1 > diff2) {
                sum1 += diff1;
                i++;
            } else {
                sum2 -= diff2;
                j--;
            }
            ans++;
        }
        return ans;
    }
}