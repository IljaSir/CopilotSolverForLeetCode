class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] diff = new int[n];
        int sum = 0;
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
            if (diff[i] > max) {
                max = diff[i];
                index = i;
            }
        }
        int ans = sum - max;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == index) continue;
            int temp = Math.abs(nums1[i] - nums2[index]);
            if (temp < min) {
                min = temp;
            }
        }
        ans += min;
        return ans % 1000000007;
    }
}