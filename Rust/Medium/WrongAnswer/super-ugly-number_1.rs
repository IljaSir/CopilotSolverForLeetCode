impl Solution {
    pub fn nth_super_ugly_number(n: i32, primes: Vec<i32>) -> i32 {
        

        let mut dp = vec![0; n as usize];
        let mut idx = vec![0; primes.len()];
        dp[0] = 1;
        for i in 1..n as usize {
            let mut min = std::i32::MAX;
            for j in 0..primes.len() {
                min = min.min(primes[j] * dp[idx[j] as usize]);
            }
            dp[i] = min;
            for j in 0..primes.len() {
                if min == primes[j] * dp[idx[j] as usize] {
                    idx[j] += 1;
                }
            }
        }
        dp[n as usize - 1]
    }
}