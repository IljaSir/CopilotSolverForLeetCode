class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + diff[i]) % 1000000007;
            max = Math.max(max, diff[i]);
        }
        int[] nums1Sorted = nums1.clone();
        Arrays.sort(nums1Sorted);
        for (int i = 0; i < n; i++) {
            int target = nums2[i];
            int index = Arrays.binarySearch(nums1Sorted, target);
            if (index < 0) {
                index = -index - 1;
            }
            if (index < n) {
                max = Math.max(max, diff[i] - (nums1Sorted[index] - target));
            }
            if (index > 0) {
                max = Math.max(max, diff[i] - (target - nums1Sorted[index - 1]));
            }
        }
        return (sum - max + 1000000007) % 1000000007;
    }
}