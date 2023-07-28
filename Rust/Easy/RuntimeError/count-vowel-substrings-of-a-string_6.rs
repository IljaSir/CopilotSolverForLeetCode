impl Solution {
    pub fn count_vowel_substrings(word: String) -> i32 {
        
        let mut dp = vec![vec![0; word.len()]; 5];
        let mut ans = 0;
        for i in 0..word.len() {
            let c = word.as_bytes()[i] - b'a';
            dp[c as usize][i] = 1;
            ans += 1;
        }
        for i in 1..word.len() {
            for j in 0..5 {
                if j > 0 {
                    dp[j as usize][i] += dp[j as usize - 1][i - 1];
                }
                ans += dp[j as usize][i];
            }
        }
        ans
    }
}