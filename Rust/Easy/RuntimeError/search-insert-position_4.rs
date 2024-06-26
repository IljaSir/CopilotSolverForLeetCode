impl Solution {
    pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut left = 0;
        let mut right = nums.len() - 1;
        let mut mid = 0;
        while left <= right {
            mid = (left + right) / 2;
            if nums[mid] == target {
                return mid as i32;
            } else if nums[mid] < target {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if nums[mid] < target {
            return (mid + 1) as i32;
        } else {
            return mid as i32;
        }
    }
}