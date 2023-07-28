impl Solution {
    pub fn vowel_strings(words: Vec<String>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut ans = vec![];
        let mut dp = vec![vec![0; 5]; words.len()];
        for i in 0..words.len() {
            for j in 0..5 {
                if words[i].as_bytes()[0] == b'a' + j as u8 {
                    dp[i][j] = 1;
                }
            }
            for j in 0..5 {
                if i > 0 {
                    dp[i][j] += dp[i-1][j];
                }
            }
        }
        for i in 0..queries.len() {
            let mut cnt = 0;
            for j in 0..5 {
                cnt += dp[queries[i][1] as usize][j];
                if queries[i][0] > 0 {
                    cnt -= dp[queries[i][0] as usize - 1][j];
                }
            }
            ans.push(cnt);
        }
        ans
    }
}