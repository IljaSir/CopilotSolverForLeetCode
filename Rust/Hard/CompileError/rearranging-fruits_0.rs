impl Solution {
    pub fn min_cost(basket1: Vec<i32>, basket2: Vec<i32>) -> i64 {
        
        let mut sum1 = basket1.iter().fold(0, |acc, &x| acc + x);
        let mut sum2 = basket2.iter().fold(0, |acc, &x| acc + x);
        let mut sum = sum1 + sum2;
        let mut dp = vec![vec![0; 3]; 3];
        for i in 0..3 {
            for j in 0..3 {
                dp[i][j] = if basket1[i] == basket2[j] { sum - basket1[i] } else { sum };
            }
        }
        for i in 0..3 {
            for j in 0..3 {
                if i != j {
                    for k in 0..3 {
                        if i != k && j != k {
                            dp[i][j] = std::cmp::min(dp[i][j], dp[i][k] + dp[k][j] - basket2[k]);
                        }
                    }
                }
            }
        }
        let mut res = std::i64::MAX;
        for i in 0..3 {
            for j in 0..3 {
                if i != j {
                    res = std::cmp::min(res, dp[i][j]);
                }
            }
        }
        res as i64
    }
}