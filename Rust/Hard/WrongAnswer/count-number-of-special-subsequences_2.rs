impl Solution {
    pub fn count_special_subsequences(nums: Vec<i32>) -> i32 {
        
        let mut dp = [0; 3];
        for num in nums {
            dp[num as usize] = (dp[num as usize] + dp[(num - 1).max(0) as usize] + 1) % 1_000_000_007;
        }
        dp[2]
    }
}