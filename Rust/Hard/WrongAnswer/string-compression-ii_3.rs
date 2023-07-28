impl Solution {
    pub fn get_length_of_optimal_compression(s: String, k: i32) -> i32 {
        
        let n = s.len();
        let mut dp = vec![vec![0; k as usize + 1]; n + 1];
        for i in 1..=n {
            let mut count = vec![0; 26];
            let mut max_char_count = 0;
            for j in i..=n {
                let idx = s.as_bytes()[j - 1] - b'a';
                count[idx as usize] += 1;
                max_char_count = max_char_count.max(count[idx as usize]);
                let mut delete_count = j - i + 1 - max_char_count;
                for l in 0..=k as usize {
                    if delete_count <= l {
                        dp[j][l] = dp[j][l].max(dp[i - 1][l - delete_count] + 1 + if max_char_count > 9 { 2 } else if max_char_count > 1 { 1 } else { 0 });
                    }
                }
            }
        }
        n as i32 - dp[n][k as usize]
    }
}