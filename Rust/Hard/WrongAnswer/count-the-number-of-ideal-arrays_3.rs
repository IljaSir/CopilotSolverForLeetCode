impl Solution {
    pub fn ideal_arrays(n: i32, max_value: i32) -> i32 {
        
        let mut dp = vec![vec![0; max_value as usize + 1]; n as usize + 1];
        let mut sum = vec![0; max_value as usize + 1];
        let mut res = 0;
        for i in 1..=max_value {
            dp[1][i as usize] = 1;
            sum[i as usize] = (sum[i as usize - 1] + dp[1][i as usize]) % 1000000007;
        }
        for i in 2..=n {
            for j in 1..=max_value {
                let mut k = j;
                while k <= max_value {
                    dp[i as usize][k as usize] = (dp[i as usize][k as usize] + sum[j as usize - 1]) % 1000000007;
                    k += j;
                }
                sum[j as usize] = (sum[j as usize - 1] + dp[i as usize][j as usize]) % 1000000007;
            }
        }
        for i in 1..=max_value {
            res = (res + dp[n as usize][i as usize]) % 1000000007;
        }
        res
    }
}