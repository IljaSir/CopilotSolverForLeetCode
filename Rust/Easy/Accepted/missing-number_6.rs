impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
        }
        let n = nums.len();
        (n * (n + 1) / 2) as i32 - sum
    }
}