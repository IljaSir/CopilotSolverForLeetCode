class Solution {
    public int search(int[] nums, int target) {
        
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int start = l;
        l = 0;
        r = n - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int realMid = (mid + start) % n;
            if(nums[realMid] == target) {
                return realMid;
            } else if(nums[realMid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}