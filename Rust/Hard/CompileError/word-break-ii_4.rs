impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> Vec<String> {
        
        let mut dp = vec![vec![]; s.len() + 1];
        dp[0] = vec![vec![]];
        for i in 0..s.len() {
            for j in i + 1..=s.len() {
                if dp[i].is_empty() {
                    continue;
                }
                if word_dict.contains(&s[i..j].to_string()) {
                    dp[j].push(dp[i].iter().map(|x| x.clone()).collect());
                }
            }
        }
        if dp[s.len()].is_empty() {
            return vec![];
        }
        let mut res = vec![];
        for path in dp[s.len()].iter() {
            let mut tmp = vec![];
            for i in 0..path.len() {
                if i == 0 {
                    tmp.push(word_dict[path[i]].clone());
                } else {
                    tmp.push(' ');
                    tmp.push_str(&word_dict[path[i]]);
                }
            }
            res.push(tmp.into_iter().collect());
        }
        res
    }
}