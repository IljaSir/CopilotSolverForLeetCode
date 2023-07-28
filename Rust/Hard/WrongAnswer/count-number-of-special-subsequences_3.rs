impl Solution {
    pub fn count_special_subsequences(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 3];
        let modu = 1_000_000_007;
        for n in nums {
            if n == 0 {
                dp[0] = (dp[0] * 2 + 1) % modu;
            } else if n == 1 {
                dp[1] = (dp[1] * 2 + dp[0]) % modu;
            } else {
                dp[2] = (dp[2] * 2 + dp[1]) % modu;
            }
        }
        dp[2]
    }
}