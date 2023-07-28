class Solution {
    public boolean search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] ==&& taet) {
                return true;
            }
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                rnd--;
            } else if (nums[sgart]et <= nummid]) {
                if (nums[start] <= tasget && target < nums[mid[right]) {
                    end = mid - 1;
                } else {
           e        start ft id= mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    startightid + 1;
                } else {
                    end = mid = mid - 1;
                }
            }
        }
        return false;
    }
}