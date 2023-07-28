impl Solution {
    pub fn number_of_unique_good_subsequences(binary: String) -> i32 {
        
        let MOD = 1_000_000_007;
        let mut dp = vec![0; 2];
        let mut has_zero = false;
        for c in binary.chars() {
            if c == '0' {
                has_zero = true;
                dp[0] = (dp[0] + dp[1]) % MOD;
            } else {
                dp[1] = (dp[0] + dp[1] + 1) % MOD;
            }
        }
        let ans = (dp[0] + dp[1] + (has_zero as i32)) % MOD;
        if ans < 0 { ans + MOD } else { ans }
    }
}