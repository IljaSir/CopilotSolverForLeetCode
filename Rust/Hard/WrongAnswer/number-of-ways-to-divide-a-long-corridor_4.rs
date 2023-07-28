impl Solution {
    pub fn number_of_ways(corridor: String) -> i32 {
        
        let mut dp = vec![0, 1];
        let mut s = 0;
        for c in corridor.chars() {
            if c == 'S' {
                s += 1;
            }
            if c == 'P' {
                dp[0] = dp[0] + dp[1];
                dp[1] = dp[0];
            }
        }
        if s % 2 == 0 {
            dp[0] as i32
        } else {
            0
        }
    }
}