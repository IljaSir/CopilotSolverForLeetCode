impl Solution {
    pub fn longest_str_chain(words: Vec<String>) -> i32 {
        
        let mut words = words;
        words.sort_by_key(|s| s.len());
        let mut dp = vec![1; words.len()];
        let mut ans = 1;
        for i in 0..words.len() {
            for j in 0..i {
                if words[i].len() - words[j].len() > 1 {
                    continue;
                }
                let mut diff = 0;
                let mut k = 0;
                let mut l = 0;
                while k < words[i].len() && l < words[j].len() {
                    if words[i].as_bytes()[k] == words[j].as_bytes()[l] {
                        k += 1;
                        l += 1;
                    } else {
                        diff += 1;
                        k += 1;
                    }
                }
                if diff == 1 || (diff == 0 && words[i].len() > words[j].len()) {
                    dp[i] = dp[i].max(dp[j] + 1);
                    ans = ans.max(dp[i]);
                }
            }
        }
        ans
    }
}