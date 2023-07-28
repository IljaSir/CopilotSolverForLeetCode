impl Solution {
    pub fn longest_square_streak(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![1; nums.len()];
        let mut max = 0;
        for i in 1..nums.len() {
            for j in 0..i {
                if nums[i] == nums[j] * nums[j] {
                    dp[i] = std::cmp::max(dp[i], dp[j] + 1);
                }
            }
            max = std::cmp::max(max, dp[i]);
        }
        if max >= 2 { max } else { -1 }
    }
}