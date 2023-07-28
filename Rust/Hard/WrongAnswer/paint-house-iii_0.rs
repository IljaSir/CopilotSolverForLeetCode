impl Solution {
    pub fn min_cost(houses: Vec<i32>, cost: Vec<Vec<i32>>, m: i32, n: i32, target: i32) -> i32 {
        
        let m = m as usize;
        let n = n as usize;
        let target = target as usize;
        let mut dp = vec![vec![vec![std::i32::MAX; target + 1]; n + 1]; m + 1];
        for i in 0..=n {
            dp[0][i][0] = 0;
        }
        for i in 1..=m {
            for j in 1..=n {
                for k in 1..=target {
                    if houses[i - 1] != 0 && houses[i - 1] != j as i32 {
                        continue;
                    }
                    for p in 1..=n {
                        if p == j {
                            dp[i][j][k] = dp[i][j][k].min(dp[i - 1][p][k]);
                        } else {
                            dp[i][j][k] = dp[i][j][k].min(dp[i - 1][p][k - 1]);
                        }
                    }
                    if dp[i][j][k] != std::i32::MAX {
                        dp[i][j][k] += if houses[i - 1] != 0 { 0 } else { cost[i - 1][j - 1] };
                    }
                }
            }
        }
        let mut res = std::i32::MAX;
        for i in 1..=n {
            res = res.min(dp[m][i][target]);
        }
        if res == std::i32::MAX {
            -1
        } else {
            res
        }
    }
}