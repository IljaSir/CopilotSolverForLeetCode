impl Solution {
    pub fn is_monotonic(nums: Vec<i32>) -> bool {
        
        let mut is_increasing = true;
        let mut is_decreasing = true;
        for i in 0..nums.len() - 1 {
            if nums[i] < nums[i + 1] {
                is_decreasing = false;
            }
            if nums[i] > nums[i + 1] {
                is_increasing = false;
            }
        }
        is_increasing || is_decreasing
    }
}