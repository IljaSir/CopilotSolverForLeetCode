impl Solution {
    pub fn max_jump(stones: Vec<i32>) -> i32 {
        
        let n = stones.len();
        let mut dp = vec![vec![0; n]; n];
        dp[0][0] = 1;
        for i in 1..n {
            for j in 0..i {
                let dist = stones[i] - stones[j];
                if dist > j as i32 + 1 {
                    continue;
                }
                for k in 0..n {
                    if dp[j][k] > 0 {
                        dp[i][k] = 1;
                        if k > 0 {
                            dp[i][k - 1] = 1;
                        }
                        if k + 1 < n {
                            dp[i][k + 1] = 1;
                        }
                    }
                }
            }
        }
        let mut res = n as i32;
        for i in 0..n {
            if dp[n - 1][i] > 0 {
                res = i as i32;
                break;
            }
        }
        res
    }
}