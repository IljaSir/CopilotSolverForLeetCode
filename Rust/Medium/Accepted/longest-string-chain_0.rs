impl Solution {
    pub fn longest_str_chain(words: Vec<String>) -> i32 {
        
        let mut words = words;
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut dp = vec![1; words.len()];
        let mut res = 0;
        for i in 0..words.len() {
            for j in 0..i {
                if words[i].len() - words[j].len() == 1 && Solution::is_predecessor(&words[i], &words[j]) {
                    dp[i] = dp[i].max(dp[j] + 1);
                }
            }
            res = res.max(dp[i]);
        }
        res
    }
    fn is_predecessor(a: &String, b: &String) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < a.len() && j < b.len() {
            if a.as_bytes()[i] != b.as_bytes()[j] {
                if i > j {
                    return false;
                }
                i += 1;
            } else {
                i += 1;
                j += 1;
            }
        }
        true
    }
}