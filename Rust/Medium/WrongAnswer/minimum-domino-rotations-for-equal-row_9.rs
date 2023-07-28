impl Solution {
    pub fn min_domino_rotations(tops: Vec<i32>, bottoms: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![i32::max_value(); 6]; 2];
        let mut min = i32::max_value();
        for i in 0..tops.len() {
            for j in 0..6 {
                if tops[i] == j as i32 + 1 && bottoms[i] == j as i32 + 1 {
                    if i == 0 {
                        dp[0][j] = 0;
                        dp[1][j] = 0;
                    } else {
                        dp[0][j] = dp[0][j].min(dp[1][j]);
                        dp[1][j] = dp[1][j].min(dp[0][j]);
                    }
                } else if tops[i] == j as i32 + 1 {
                    if i == 0 {
                        dp[0][j] = 0;
                    } else {
                        dp[0][j] = dp[0][j].min(dp[1][j] + 1);
                    }
                } else if bottoms[i] == j as i32 + 1 {
                    if i == 0 {
                        dp[1][j] = 0;
                    } else {
                        dp[1][j] = dp[1][j].min(dp[0][j] + 1);
                    }
                } else {
                    dp[0][j] = i32::max_value();
                    dp[1][j] = i32::max_value();
                }
                min = min.min(dp[0][j]).min(dp[1][j]);
            }
        }
        if min == i32::max_value() {
            -1
        } else {
            min as i32
        }
    }
}