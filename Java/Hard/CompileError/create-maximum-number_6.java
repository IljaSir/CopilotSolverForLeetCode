class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        
        int[] result = new int[k];
        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);
        for (int i = start; i <= end; i++) {
            int[] max1 = maxArray(nums1, i);
            int[] max2 = maxArray(nums2, k - i);
            int[] curr = merge(max1, max2);
            if (greater(curr, 0, result, 0)) {
                result = curr;
            }
        }
        return result;
    }
    
    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top >= 0 && top + n - i >= k && nums[i] > result[top]) {
                top--;
            }
            if (top < k - 1) {
                result[++top] = nums[i];
            }
        }
        return result;
    }
    
    public int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 == 0) {
            return nums2;
        }
        if (n2 == 0) {
            return nums1;
        }
        int[] result = new int[n1 + n2];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < n1 || index2 < n2) {
            result[index++] = greater(nums1, index1, nums2, index2) ? nums1[index1++] : nums2[index2++];
        }
        return result;
    }
    
    public boolean greater(int[] nums1, int index1, int[] nums2, int index2) {
        int n1 = nums1.length, n2 = nums2.length;
        while (index1 < n1 && index2 < n2) {
            int diff = nums1[index1] - nums2[index2];
            if (diff != 0) {
                return diff > 0;
            }
            index1++;
            index2++;
        }
        return (n1 - index1) > (n2
    }
}