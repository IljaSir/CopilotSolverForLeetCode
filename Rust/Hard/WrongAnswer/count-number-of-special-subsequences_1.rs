impl Solution {
    pub fn count_special_subsequences(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 3];
        for &n in nums.iter() {
            dp[n as usize] = (dp[n as usize] * 2 + if n == 0 { 1 } else { dp[(n - 1) as usize] }) % 1_000_000_007;
        }
        dp[2]
    }
}