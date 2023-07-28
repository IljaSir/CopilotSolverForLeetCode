impl Solution {
    pub fn is_monotonic(nums: Vec<i32>) -> bool {
        
        if nums.len() < 2 {
            return true;
        }
        let mut inc = false;
        let mut dec = false;
        for i in 1..nums.len() {
            if nums[i] > nums[i-1] {
                inc = true;
            } else if nums[i] < nums[i-1] {
                dec = true;
            }
            if inc && dec {
                return false;
            }
        }
        true
    }
}