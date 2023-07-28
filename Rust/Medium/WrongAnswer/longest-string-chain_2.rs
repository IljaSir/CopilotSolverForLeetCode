impl Solution {
    pub fn longest_str_chain(words: Vec<String>) -> i32 {
        
        let mut words: Vec<Vec<char>> = words.into_iter().map(|w| w.chars().collect()).collect();
        words.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut dp: Vec<i32> = vec![1; words.len()];
        let mut max_len: i32 = 1;
        for i in 1..words.len() {
            for j in 0..i {
                if words[i].len() - words[j].len() > 1 {
                    continue;
                }
                let mut is_predecessor = true;
                let mut l = 0;
                let mut r = 0;
                while l < words[j].len() && r < words[i].len() {
                    if words[j][l] == words[i][r] {
                        l += 1;
                        r += 1;
                    } else {
                        if l != r {
                            is_predecessor = false;
                            break;
                        }
                        r += 1;
                    }
                }
                if is_predecessor && l == words[j].len() {
                    dp[i] = std::cmp::max(dp[i], dp[j] + 1);
                }
            }
            max_len = std::cmp::max(max_len, dp[i]);
        }
        max_len
    }
}