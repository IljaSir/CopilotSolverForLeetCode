impl Solution {
    pub fn find_min(nums: Vec<i32>) -> i32 {
        

        let n = nums.len();
        if n == 1 {
            return nums[0];
        }
        if nums[0] < nums[n - 1] {
            return nums[0];
        }
        let mut left = 0;
        let mut right = n - 1;
        while left <= right {
            let mid = left + (right - left) / 2;
            if nums[mid] > nums[mid + 1] {
                return nums[mid + 1];
            }
            if nums[mid - 1] > nums[mid] {
                return nums[mid];
            }
            if nums[mid] > nums[0] {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        0
    }
}