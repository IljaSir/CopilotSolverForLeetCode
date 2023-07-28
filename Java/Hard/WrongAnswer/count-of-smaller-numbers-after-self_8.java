class Solution {
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        int[] count = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = binarySearch(nums, i + 1, nums.length - 1, nums[i]);
            if (index == nums.length) {
                count[i] = 0;
            } else {
                count[i] = index - i;
            }
        }
        for (int i = 0; i < count.length; i++) {
            result.add(count[i]);
        }
        return result;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return nums.length;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return binarySearch(nums, start, mid - 1, target);
        }
    }
}