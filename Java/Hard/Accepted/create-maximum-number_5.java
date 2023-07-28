class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        
        int[] res = new int[k];
        int m = nums1.length;
        int n = nums2.length;
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, res, 0)) {
                res = candidate;
            }
        }
        return res;
    }

    // find the maximum number of length k in the array
    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && res[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }

    // merge two arrays
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }

    // compare two arrays
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}