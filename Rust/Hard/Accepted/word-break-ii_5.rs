impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> Vec<String> {
        
        let mut dp = vec![vec![]; s.len() + 1];
        dp[0] = vec![vec![]];
        for i in 0..s.len() {
            for j in i..s.len() {
                if dp[i].len() > 0 && word_dict.contains(&s[i..j+1].to_string()) {
                    let mut tmp = dp[i].clone();
                    for mut v in tmp.iter_mut() {
                        v.push(s[i..j+1].to_string());
                    }
                    dp[j + 1].append(&mut tmp);
                }
            }
        }
        let mut ans = vec![];
        for v in dp[s.len()].iter() {
            ans.push(v.join(" "));
        }
        ans
    }
}