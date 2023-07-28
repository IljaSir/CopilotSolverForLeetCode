class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
        int mod = 1000000007;
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + diff[i]) % mod;
        }
        Arrays.sort(nums1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int index = binarySearch(nums1, nums2[i]);
            if (index < n) {
                max = Math.max(max, diff[i] - (Math.abs(nums1[index] - nums2[i])));
            }
            if (index > 0) {
                max = Math.max(max, diff[i] - (Math.abs(nums1[index - 1] - nums2[i])));
            }
        }
        return (sum - max + mod) % mod;
    }
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low] >= target ? low : low + 1;
    }
}