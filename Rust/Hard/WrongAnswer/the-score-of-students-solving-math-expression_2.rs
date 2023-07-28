impl Solution {
    pub fn score_of_students(s: String, answers: Vec<i32>) -> i32 {
        
        let n = s.len();
        let mut dp = vec![vec![vec![0; 1001]; n + 1]; n + 1];
        for i in 0..n {
            if let Ok(d) = s[i..i + 1].parse::<i32>() {
                dp[i][i + 1][d as usize] = 1;
            }
        }
        for l in 2..=n {
            for i in 0..=n - l {
                let j = i + l;
                for k in i + 1..j {
                    for a in 0..=1000 {
                        for b in 0..=1000 {
                            let c = a + b;
                            if c <= 1000 {
                                dp[i][j][c] += dp[i][k][a] * dp[k][j][b];
                            }
                        }
                    }
                }
                if s[i..j].contains('*') {
                    for k in i + 1..j {
                        for a in 0..=1000 {
                            for b in 0..=1000 {
                                let c = a * b;
                                if c <= 1000 {
                                    dp[i][j][c] += dp[i][k][a] * dp[k][j][b];
                                }
                            }
                        }
                    }
                }
            }
        }
        let mut res = 0;
        for a in answers {
            if dp[0][n][a as usize] > 0 {
                res += 5;
            } else {
                for b in 0..=1000 {
                    if dp[0][n][b] > 0 && a == (b as i32) {
                        res += 2;
                        break;
                    }
                }
            }
        }
        res
    }
}