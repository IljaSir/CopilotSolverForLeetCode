impl Solution {
    pub fn find_target_sum_ways(nums: Vec<i32>, target: i32) -> i32 {
        

        let mut dp = vec![vec![0; 2001]; nums.len()];
        dp[0][nums[0] as usize + 1000] += 1;
        dp[0][-nums[0] as usize + 1000] += 1;
        for i in 1..nums.len() {
            for sum in -1000..=1000 {
                if dp[i - 1][sum as usize + 1000] > 0 {
                    dp[i][sum as usize + nums[i] as usize + 1000] += dp[i - 1][sum as usize + 1000];
                    dp[i][sum as usize - nums[i] as usize + 1000] += dp[i - 1][sum as usize + 1000];
                }
            }
        }
        if target > 1000 {
            return 0;
        }
        dp[nums.len() - 1][target as usize + 1000]
    }
}