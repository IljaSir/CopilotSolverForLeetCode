impl Solution {
    pub fn min_cost(houses: Vec<i32>, cost: Vec<Vec<i32>>, m: i32, n: i32, target: i32) -> i32 {
        
        let m = m as usize;
        let n = n as usize;
        let target = target as usize;
        let mut dp = vec![vec![vec![1_000_000_000; n]; target + 1]; m + 1];
        if houses[0] > 0 {
            dp[0][0][houses[0] as usize - 1] = 0;
        } else {
            (0..n).for_each(|i| dp[0][0][i] = cost[0][i]);
        }
        for i in 1..m {
            if houses[i] > 0 {
                let h = houses[i] as usize - 1;
                for j in 0..n {
                    if j == h {
                        dp[i][1][j] = dp[i - 1][0][j];
                    } else {
                        dp[i][1][j] = dp[i - 1][1][j];
                    }
                }
            } else {
                for j in 0..n {
                    for k in 1..target + 1 {
                        for l in 0..n {
                            if j != l {
                                dp[i][k][j] = dp[i][k][j].min(dp[i - 1][k - 1][l]);
                            } else {
                                dp[i][k][j] = dp[i][k][j].min(dp[i - 1][k][l]);
                            }
                        }
                        dp[i][k][j] += cost[i][j];
                    }
                }
            }
        }
        let mut res = 1_000_000_000;
        for i in 0..n {
            res = res.min(dp[m - 1][target][i]);
        }
        if res >= 1_000_000_000 {
            return -1;
        }
        res as i32
    }
}