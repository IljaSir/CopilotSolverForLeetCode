impl Solution {
    pub fn num_rolls_to_target(n: i32, k: i32, target: i32) -> i32 {
        
        let mut dp = vec![vec![0; target as usize + 1]; n as usize + 1];
        dp[0][0] = 1;
        let modu = 1000000007;
        for i in 1..=n {
            for j in 1..=target {
                let mut sum = 0;
                for x in 1..=k {
                    if j >= x {
                        sum = (sum + dp[(i - 1) as usize][(j - x) as usize]) % modu;
                    }
                }
                dp[i as usize][j as usize] = sum;
            }
        }
        dp[n as usize][target as usize]
    }
}