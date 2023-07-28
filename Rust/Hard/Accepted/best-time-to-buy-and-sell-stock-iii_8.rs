impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; 5]; prices.len()];
        for i in 0..prices.len() {
            for j in 0..5 {
                dp[i][j] = match j {
                    0 => 0,
                    1 => {
                        if i == 0 {
                            -prices[i]
                        } else {
                            std::cmp::max(dp[i - 1][1], -prices[i])
                        }
                    }
                    2 => {
                        if i == 0 {
                            0
                        } else {
                            std::cmp::max(dp[i - 1][2], dp[i - 1][1] + prices[i])
                        }
                    }
                    3 => {
                        if i == 0 {
                            -prices[i]
                        } else {
                            std::cmp::max(dp[i - 1][3], dp[i - 1][2] - prices[i])
                        }
                    }
                    4 => {
                        if i == 0 {
                            0
                        } else {
                            std::cmp::max(dp[i - 1][4], dp[i - 1][3] + prices[i])
                        }
                    }
                    _ => unreachable!(),
                }
            }
        }
        dp[prices.len() - 1][4]
    }
}