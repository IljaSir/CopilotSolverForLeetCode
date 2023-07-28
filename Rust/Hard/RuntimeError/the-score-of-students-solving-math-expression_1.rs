impl Solution {
    pub fn score_of_students(s: String, answers: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![0; 1001]; s.len()];
        dp[0][s.chars().nth(0).unwrap().to_digit(10).unwrap() as usize] = 1;
        for i in 1..s.len() {
            let c = s.chars().nth(i).unwrap();
            if c == '*' {
                for j in 0..1001 {
                    for k in 0..1001 {
                        if dp[i - 2][j] > 0 && dp[i - 2][k] > 0 {
                            dp[i][j * k] = 1;
                        }
                    }
                }
            } else if c == '+' {
                for j in 0..1001 {
                    for k in 0..1001 {
                        if dp[i - 2][j] > 0 && dp[i - 2][k] > 0 {
                            dp[i][j + k] = 1;
                        }
                    }
                }
            } else {
                for j in 0..1001 {
                    if dp[i - 2][j] > 0 {
                        dp[i][j * 10 + c.to_digit(10).unwrap() as usize] = 1;
                    }
                }
            }
        }
        let mut res = 0;
        for i in 0..answers.len() {
            let ans = answers[i];
            if ans == dp[s.len() - 1][ans as usize] {
                res += 5;
            } else if ans <= 1000 {
                let mut flag = true;
                for j in 0..s.len() {
                    if dp[j][ans as usize] > 0 {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    res += 2;
                }
            }
        }
        res
    }
}