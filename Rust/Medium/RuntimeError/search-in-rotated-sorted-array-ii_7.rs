impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> bool {
        

        let mut left = 0;
        let mut right = nums.len() - 1;
        let mut mid = 0;
        while left <= right {
            mid = left + (right - left) / 2;
            if nums[mid] == target {
                return true;
            }
            if nums[mid] == nums[right] {
                right -= 1;
                continue;
            }
            if nums[mid] < nums[right] {
                if target > nums[mid] && target <= nums[right] {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if target >= nums[left] && target < nums[mid] {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        false
    }
}