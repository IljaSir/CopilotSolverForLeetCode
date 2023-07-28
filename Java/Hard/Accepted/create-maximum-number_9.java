class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        
        int[] res = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] cand = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(cand, 0, res, 0)) {
                res = cand;
            }
        }
        return res;
    }

    public int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public int[] maxArray(int[] nums, int k) {
        int[] res = new int[k];
        for (int i = 0, r = 0; i < nums.length; i++) {
            while (nums.length - i + r > k && r > 0 && res[r - 1] < nums[i]) {
                r--;
            }
            if (r < k) {
                res[r++] = nums[i];
            }
        }
        return res;
    }
}