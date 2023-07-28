impl Solution {
    pub fn get_length_of_optimal_compression(s: String, k: i32) -> i32 {
        
        let n = s.len();
        let s = s.as_bytes();
        let mut dp = vec![vec![vec![0; n + 1]; n + 1]; n + 1];
        for i in 0..n {
            for j in 0..n {
                for l in 0..n {
                    dp[i][j][l] = n as i32;
                }
            }
        }
        for i in 0..n {
            dp[i][i][1] = 1;
        }
        for l in 2..=n {
            for i in 0..n {
                let j = i + l - 1;
                if j >= n {
                    break;
                }
                for p in i..j {
                    for q in 0..=k {
                        dp[i][j][q as usize] = dp[i][j][q as usize].min(dp[i][p][q as usize] + dp[p + 1][j][0]);
                    }
                }
                let mut count = 1;
                for p in i + 1..=j {
                    if s[p] == s[i] {
                        count += 1;
                    } else {
                        break;
                    }
                }
                let mut t = count.to_string().len() as i32 + 1;
                if count == 2 || count == 3 {
                    t -= 1;
                }
                for q in 0..=k {
                    dp[i][j][q as usize] = dp[i][j][q as usize].min(dp[i + count][j][q as usize] + t);
                }
                for p in i + 1..=j {
                    for q in 0..k {
                        dp[i][j][(q + 1) as usize] = dp[i][j][(q + 1) as usize].min(dp[i][p - 1][q as usize] + dp[p][j][0]);
                    }
                }
            }
        }
        dp[0][n - 1][k as usize]
    }
}