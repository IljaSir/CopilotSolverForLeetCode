impl Solution {
    pub fn min_cost(houses: Vec<i32>, cost: Vec<Vec<i32>>, m: i32, n: i32, target: i32) -> i32 {
        
        let m = m as usize;
        let n = n as usize;
        let target = target as usize;
        let mut dp = vec![vec![vec![vec![i32::MAX; n]; target + 1]; m + 1]; m + 1];
        for i in 1..=m {
            let c = houses[i - 1] as usize;
            for j in 1..=n {
                if c == 0 || c == j {
                    dp[i][1][i][j - 1] = if c == 0 { cost[i - 1][j - 1] } else { 0 };
                }
            }
        }
        for i in 1..=m {
            for j in 1..=i {
                for k in 1..=target {
                    for l in 1..=n {
                        for p in 1..=n {
                            if l != p {
                                dp[i][k][j][l - 1] = dp[i][k][j][l - 1].min(dp[i - 1][k - 1][j][p - 1]);
                            }
                            dp[i][k][j][l - 1] = dp[i][k][j][l - 1].min(dp[i - 1][k][j][p - 1]);
                        }
                    }
                }
            }
        }
        let mut res = i32::MAX;
        for i in 1..=n {
            res = res.min(dp[m][target][1][i - 1]);
        }
        if res >= i32::MAX {
            return -1;
        }
        res
    }
}