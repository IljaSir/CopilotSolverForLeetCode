impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        

        let mut left = 0;
        let mut right = nums.len() - 1;
        while left <= right {
            let mid = (left + right) / 2;
            if nums[mid] == target {
                return mid as i32;
            }
            if nums[mid] >= nums[left] {
                if target >= nums[left] && target < nums[mid] {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if target > nums[mid] && target <= nums[right] {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        -1
    }
}