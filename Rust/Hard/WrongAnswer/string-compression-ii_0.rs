impl Solution {
    pub fn get_length_of_optimal_compression(s: String, k: i32) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut dp = vec![vec![0; k as usize + 1]; n + 1];
        for i in 1..=n {
            let mut cnt = vec![0; 26];
            let mut cur = 0;
            for j in i..=n {
                cnt[(s[j - 1] - b'a') as usize] += 1;
                if cnt[(s[j - 1] - b'a') as usize] == 1 {
                    cur += 1;
                }
                if cnt[(s[j - 1] - b'a') as usize] == 2 {
                    cur -= 1;
                }
                let mut t = cur;
                if cnt[(s[j - 1] - b'a') as usize] > 2 {
                    t += 1;
                }
                for l in 0..=k as usize {
                    if l < j - i + 1 {
                        dp[j][l] = dp[i - 1][l];
                    } else {
                        dp[j][l] = dp[j][l].min(dp[i - 1][l - (j - i + 1)] + t);
                    }
                }
            }
        }
        dp[n][k as usize] as i32
    }
}