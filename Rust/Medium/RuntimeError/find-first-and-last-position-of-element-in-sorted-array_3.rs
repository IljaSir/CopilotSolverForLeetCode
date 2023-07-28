impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        

        let mut first = -1;
        let mut last = -1;
        let mut left = 0;
        let mut right = nums.len() - 1;
        while left <= right {
            let mid = (left + right) / 2;
            if nums[mid] == target {
                first = mid as i32;
                right = mid - 1;
            } else if nums[mid] > target {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = nums.len() - 1;
        while left <= right {
            let mid = (left + right) / 2;
            if nums[mid] == target {
                last = mid as i32;
                left = mid + 1;
            } else if nums[mid] > target {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        vec![first, last]
    }
}