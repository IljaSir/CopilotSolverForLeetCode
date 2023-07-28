impl Solution {
    pub fn num_ways(words: Vec<String>, target: String) -> i32 {
        
        let mut dp = vec![vec![0; target.len() + 1]; words.len() + 1];
        dp[0][0] = 1;
        for i in 0..words.len() {
            for j in 0..=target.len() {
                dp[i+1][j] += dp[i][j];
                if j < target.len() && words[i].contains(target.chars().nth(j).unwrap()) {
                    dp[i+1][j+1] += dp[i][j];
                }
            }
        }
        dp[words.len()][target.len()]
    }
}