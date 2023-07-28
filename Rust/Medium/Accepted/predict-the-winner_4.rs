impl Solution {
    pub fn predict_the_winner(nums: Vec<i32>) -> bool {
        

        let mut dp = vec![0; nums.len()];
        for i in 0..nums.len() {
            dp[i] = nums[i];
        }
        for i in (0..nums.len()).rev() {
            for j in i+1..nums.len() {
                dp[j] = std::cmp::max(nums[i] - dp[j], nums[j] - dp[j-1]);
            }
        }
        dp[nums.len()-1] >= 0
    }
}