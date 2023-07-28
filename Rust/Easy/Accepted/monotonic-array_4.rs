impl Solution {
    pub fn is_monotonic(nums: Vec<i32>) -> bool {
        
        let mut increasing = true;
        let mut decreasing = true;
        for i in 0..nums.len() - 1 {
            if nums[i] < nums[i + 1] {
                decreasing = false;
            } else if nums[i] > nums[i + 1] {
                increasing = false;
            }
        }
        increasing || decreasing
    }
}