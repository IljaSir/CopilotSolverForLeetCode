impl Solution {
    pub fn number_of_arithmetic_slices(nums: Vec<i32>) -> i32 {
        

        let mut result = 0;
        let mut dp = vec![0; nums.len()];
        for i in 2..nums.len() {
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2] {
                dp[i] = dp[i - 1] + 1;
                result += dp[i];
            }
        }
        result
    }
}