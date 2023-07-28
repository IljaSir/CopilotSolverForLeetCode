impl Solution {
    pub fn vowel_strings(words: Vec<String>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result = Vec::new();
        let vowels = vec!['a', 'e', 'i', 'o', 'u'];
        let mut dp = vec![vec![0; 5]; words.len() + 1];
        for i in 0..words.len() {
            let mut index = 0;
            for c in words[i].chars() {
                if vowels.contains(&c) {
                    index = vowels.iter().position(|&r| r == c).unwrap();
                    break;
                }
            }
            for j in index..5 {
                dp[i + 1][j] = 1;
            }
        }
        for i in 1..words.len() + 1 {
            for j in 1..5 {
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
            }
        }
        for query in queries {
            result.push(dp[query[1] as usize + 1][4] - dp[query[0] as usize][4]);
        }
        result
    }
}