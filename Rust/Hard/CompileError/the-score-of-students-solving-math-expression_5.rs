impl Solution {
    pub fn score_of_students(s: String, answers: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut n = s.len();
        let mut dp = vec![vec![vec![false; n]; n]; 1001];
        let mut calc = |l, r| {
            let mut ret = vec![];
            for i in l..r {
                let ch = s.as_bytes()[i] as char;
                if ch == '+' {
                    let left = calc(l, i);
                    let right = calc(i + 1, r);
                    for &l in &left {
                        for &r in &right {
                            ret.push(l + r);
                        }
                    }
                } else if ch == '*' {
                    let left = calc(l, i);
                    let right = calc(i + 1, r);
                    for &l in &left {
                        for &r in &right {
                            ret.push(l * r);
                        }
                    }
                }
            }
            if ret.is_empty() {
                ret.push(s[l..r].parse().unwrap());
            }
            ret
        };
        let mut ans = calc(0, n);
        ans.sort();
        ans.dedup();
        for &a in &ans {
            dp[a as usize][0][n - 1] = true;
        }
        for i in 0..n {
            if s.as_bytes()[i] as char >= '0' && s.as_bytes()[i] as char <= '9' {
                dp[s.as_bytes()[i] as usize - '0' as usize][i][i] = true;
            }
        }
        for len in 1..n {
            for i in 0..=n - len - 1 {
                for j in i..i + len {
                    for k in 0..=1000 {
                        if dp[k][i][j] && dp[k][j + 1][i + len] {
                            dp[k][i][i + len] = true;
                        }
                    }
                }
                for k in 0..=1000 {
                    if dp[k][i][i + len] {
                        for l in 0..=1000 {
                            if dp[l][i + len + 1][n - 1] {
                                dp[k + l][0][n - 1] = true;
                            }
                        }
                    }
                }
            }
        }
        for &
    }
}