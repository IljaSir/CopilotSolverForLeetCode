impl Solution {
    pub fn number_of_arithmetic_slices(nums: Vec<i32>) -> i32 {
        

        if nums.len() < 3 {
            return 0;
        }
        let mut ans = 0;
        let mut dp = vec![0; nums.len()];
        for i in 2..nums.len() {
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2] {
                dp[i] = 1 + dp[i - 1];
                ans += dp[i];
            }
        }
        ans
    }
}