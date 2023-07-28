impl Solution {
    pub fn number_of_unique_good_subsequences(binary: String) -> i32 {
        
        let mut dp = vec![0; 2];
        let mut has_zero = false;
        for &c in binary.as_bytes() {
            dp[c as usize - '0' as usize] = (dp[c as usize - '0' as usize] + dp[1 - c as usize - '0' as usize] + 1) % 1_000_000_007;
            has_zero |= c == b'0';
        }
        if has_zero {
            (dp[0] + dp[1]) % 1_000_000_007
        } else {
            (dp[0] + dp[1] - 1) % 1_000_000_007
        }
    }
}