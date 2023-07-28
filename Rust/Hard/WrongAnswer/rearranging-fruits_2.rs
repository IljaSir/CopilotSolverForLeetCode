impl Solution {
    pub fn min_cost(basket1: Vec<i32>, basket2: Vec<i32>) -> i64 {
        
        let n = basket1.len();
        let mut dp = vec![vec![vec![0; 3]; 3]; n + 1];
        for i in 1..=n {
            let b1 = basket1[i - 1];
            let b2 = basket2[i - 1];
            for j in 0..3 {
                for k in 0..3 {
                    if j == k {
                        continue;
                    }
                    let mut cost = 0;
                    if j != 0 {
                        cost = dp[i - 1][j][k];
                    }
                    if k != 0 {
                        cost = std::cmp::max(cost, dp[i - 1][j][k]);
                    }
                    if j == 0 {
                        cost += b1;
                    }
                    if k == 0 {
                        cost += b2;
                    }
                    dp[i][j][k] = cost;
                }
            }
        }
        let mut res = 0;
        for j in 0..3 {
            for k in 0..3 {
                if j == k {
                    continue;
                }
                res = std::cmp::max(res, dp[n][j][k]);
            }
        }
        if res == 0 {
            -1
        } else {
            res as i64
        }
    }
}