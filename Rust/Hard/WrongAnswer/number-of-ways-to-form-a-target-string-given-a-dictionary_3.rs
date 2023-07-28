impl Solution {
    pub fn num_ways(words: Vec<String>, target: String) -> i32 {
        
        let mut dp = vec![vec![0; target.len()+1]; words.len()+1];
        let mut chs = vec![vec![0; 26]; words[0].len()];
        for i in 0..words.len() {
            for j in 0..words[i].len() {
                chs[j][words[i].as_bytes()[j] as usize - 'a' as usize] += 1;
            }
        }
        dp[0][0] = 1;
        for i in 0..words.len() {
            for j in 0..=target.len() {
                dp[i+1][j] = (dp[i+1][j] + dp[i][j]) % 1000000007;
                if j < target.len() && chs[j][target.as_bytes()[j] as usize - 'a' as usize] > 0 {
                    dp[i+1][j+1] = (dp[i+1][j+1] + dp[i][j] * chs[j][target.as_bytes()[j] as usize - 'a' as usize]) % 1000000007;
                }
            }
        }
        dp[words.len()][target.len()]
    }
}