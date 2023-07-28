impl Solution {
    pub fn number_of_unique_good_subsequences(binary: String) -> i32 {
        
        let mut dp = vec![0; 2];
        let mut has_zero = false;
        for ch in binary.chars() {
            let ch = ch as usize - '0' as usize;
            if ch == 0 {
                has_zero = true;
            } else {
                dp[1] = (dp[0] + dp[1]) % 1_000_000_007;
            }
            dp[0] = (dp[0] + dp[1]) % 1_000_000_007;
        }
        if has_zero {
            (dp[0] + dp[1] + 1) % 1_000_000_007
        } else {
            (dp[0] + dp[1]) % 1_000_000_007
        }
    }
}