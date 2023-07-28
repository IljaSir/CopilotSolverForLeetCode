impl Solution {
    pub fn longest_str_chain(words: Vec<String>) -> i32 {
        
        let mut words: Vec<Vec<char>> = words.iter().map(|s| s.chars().collect()).collect();
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut dp = vec![0; words.len()];
        let mut ans = 0;
        for i in 0..words.len() {
            for j in 0..i {
                if words[i].len() - words[j].len() == 1 && Self::is_predecessor(&words[j], &words[i]) {
                    dp[i] = dp[i].max(dp[j] + 1);
                }
            }
            ans = ans.max(dp[i]);
        }
        ans + 1
    }
    fn is_predecessor(a: &[char], b: &[char]) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < a.len() && j < b.len() {
            if a[i] == b[j] {
                i += 1;
                j += 1;
            } else {
                if i != j {
                    return false;
                }
                j += 1;
            }
        }
        true
    }
}