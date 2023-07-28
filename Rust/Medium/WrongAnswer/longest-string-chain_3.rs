impl Solution {
    pub fn longest_str_chain(words: Vec<String>) -> i32 {
        
        let mut words: Vec<String> = words;
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut dp = vec![1; words.len()];
        let mut ans = 1;
        for i in 0..words.len() {
            for j in 0..i {
                if words[i].len() - words[j].len() > 1 {
                    continue;
                }
                if Solution::is_predecessor(&words[i], &words[j]) {
                    dp[i] = dp[i].max(dp[j] + 1);
                }
            }
            ans = ans.max(dp[i]);
        }
        ans
    }
    fn is_predecessor(a: &String, b: &String) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < a.len() && j < b.len() {
            if a.as_bytes()[i] == b.as_bytes()[j] {
                i += 1;
                j += 1;
            } else {
                if i != j {
                    return false;
                }
                i += 1;
            }
        }
        true
    }
}