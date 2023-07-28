impl Solution {
    pub fn missing_number(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut sum = 0;
        for i in 0..n {
            sum += nums[i];
        }
        (n * (n + 1)) as i32 / 2 - sum
    }
}