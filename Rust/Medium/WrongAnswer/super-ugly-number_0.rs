impl Solution {
    pub fn nth_super_ugly_number(n: i32, primes: Vec<i32>) -> i32 {
        

        let n = n as usize;
        let mut dp = vec![0; n];
        dp[0] = 1;
        let mut p = vec![0; primes.len()];
        for i in 1..n {
            dp[i] = i32::MAX;
            for j in 0..primes.len() {
                dp[i] = dp[i].min(dp[p[j]] * primes[j]);
            }
            for j in 0..primes.len() {
                if dp[i] == dp[p[j]] * primes[j] {
                    p[j] += 1;
                }
            }
        }
        dp[n - 1]
    }
}