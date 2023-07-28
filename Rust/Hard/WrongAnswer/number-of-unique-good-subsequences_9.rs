impl Solution {
    pub fn number_of_unique_good_subsequences(binary: String) -> i32 {
        
        let mut dp = vec![0; 2];
        let mut modval = 1000000007;
        let mut zero = false;
        for c in binary.chars() {
            if c == '0' {
                zero = true;
                dp[0] = (dp[0] + dp[1]) % modval;
            } else {
                dp[1] = (dp[0] + dp[1] + 1) % modval;
            }
        }
        if zero {
            dp[1]
        } else {
            (dp[1] + 1) % modval
        }
    }
}