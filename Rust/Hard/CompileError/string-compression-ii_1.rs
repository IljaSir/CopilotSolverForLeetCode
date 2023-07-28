impl Solution {
    pub fn get_length_of_optimal_compression(s: String, k: i32) -> i32 {
        
        let n = s.len();
        let s = s.into_bytes();
        let mut dp = vec![vec![0; n + 1]; n + 1];
        for i in 0..=n {
            for j in 0..=n {
                dp[i][j] = n;
            }
        }
        for i in 0..=n {
            dp[i][0] = 0;
        }
        for i in 0..n {
            let mut count = vec![0; 26];
            for j in i..n {
                count[(s[j] - b'a') as usize] += 1;
                let mut max = 0;
                let mut sum = 0;
                for c in &count {
                    max = max.max(*c);
                    sum += *c;
                }
                let same = j - i + 1 - max;
                for t in 0..=same {
                    let cost = if max < 10 {
                        1
                    } else if max < 100 {
                        2
                    } else {
                        3
                    };
                    dp[j + 1][t + 1] = dp[j + 1][t + 1].min(dp[i][t] + cost);
                }
            }
        }
        for i in 0..=n {
            if dp[n][i] <= k {
                return i as i32;
            }
        }
        n as i32
    }
}