impl Solution {
    pub fn ways_to_fill_array(queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = vec![];
        let n = 1000000007;
        for q in queries {
            let (n, k) = (q[0], q[1]);
            let mut dp = vec![0; n as usize + 1];
            let mut sum = 0;
            for i in 1..=n {
                dp[i as usize] = k;
                if i > 1 {
                    dp[i as usize] = (dp[i as usize] * (i - 1)) % n;
                }
                if i > 2 {
                    dp[i as usize] = (dp[i as usize] * sum) % n;
                }
                sum = (sum + dp[i as usize]) % n;
            }
            res.push(sum as i32);
        }
        res
    }
}