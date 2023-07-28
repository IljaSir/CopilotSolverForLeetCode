impl Solution {
    pub fn total_steps(nums: Vec<i32>) -> i32 {
        
        let mut result = 0;
        for i in 1..nums.len() {
            if nums[i - 1] > nums[i] {
                result += 1;
            }
        }
        result
    }
}