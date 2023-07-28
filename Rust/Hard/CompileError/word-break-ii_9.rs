impl Solution {
    pub fn word_break(s: String, word_dict: Vec<String>) -> Vec<String> {
        
        let mut ans = vec![];
        let mut memo = vec![];
        let word_dict: Vec<&str> = word_dict.iter().map(|s| s.as_str()).collect();
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        memo.resize(n, vec![]);
        for i in (0..n).rev() {
            let mut tmp = vec![];
            for j in i..n {
                let word = &s[i..j + 1];
                let word = word.iter().collect::<String>();
                if word_dict.contains(&word.as_str()) {
                    if j == n - 1 {
                        tmp.push(word);
                    } else {
                        for word2 in &memo[j + 1] {
                            tmp.push(word + " " + word2);
                        }
                    }
                }
            }
            memo[i] = tmp;
        }
        memo[0].clone()
    }
}