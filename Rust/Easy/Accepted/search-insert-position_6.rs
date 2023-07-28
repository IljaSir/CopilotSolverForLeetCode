impl Solution {
    pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut left = 0;
        let mut right = nums.len() - 1;
        while left < right {
            let mid = left + (right - left) / 2;
            if nums[mid] < target {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if nums[left] < target {
            left as i32 + 1
        } else {
            left as i32
        }
    }
}