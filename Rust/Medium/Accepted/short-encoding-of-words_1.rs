impl Solution {
    pub fn minimum_length_encoding(words: Vec<String>) -> i32 {
        
        let mut words: Vec<String> = words.into_iter().map(|s| s.chars().rev().collect()).collect();
        words.sort();
        let mut res = 0;
        for i in 0..words.len() {
            if i == words.len() - 1 || !words[i + 1].starts_with(&words[i]) {
                res += words[i].len() + 1;
            }
        }
        res as i32
    }
}