impl Solution {
    pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
        
        let (mut left, mut right) = (0, nums.len() - 1);
        while left <= right {
            let mid = left + (right - left) / 2;
            if nums[mid] == target {
                return mid as i32;
            } else if nums[mid] > target {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left as i32
    }
}