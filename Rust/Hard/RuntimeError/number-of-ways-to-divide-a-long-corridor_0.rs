impl Solution {
    pub fn number_of_ways(corridor: String) -> i32 {
        
        let mut s = 0;
        for c in corridor.chars() {
            if c == 'S' {
                s += 1;
            }
        }
        if s % 2 != 0 {
            return 0;
        }
        let n = s / 2;
        let mut dp = vec![0; n + 1];
        dp[0] = 1;
        let mut cur = 0;
        for c in corridor.chars() {
            if c == 'S' {
                cur += 1;
            }
            if cur <= n {
                dp[cur] = (dp[cur] + dp[cur - 1]) % 1000000007;
            }
        }
        dp[n]
    }
}