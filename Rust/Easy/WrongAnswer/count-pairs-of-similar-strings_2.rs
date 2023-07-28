impl Solution {
    pub fn similar_pairs(words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for i in 0..words.len() {
            for j in i + 1..words.len() {
                if Self::is_similar(&words[i], &words[j]) {
                    count += 1;
                }
            }
        }
        count
    }
    fn is_similar(w1: &str, w2: &str) -> bool {
        if w1.len() != w2.len() {
            return false;
        }
        let mut count = 0;
        for i in 0..w1.len() {
            if w1.chars().nth(i).unwrap() != w2.chars().nth(i).unwrap() {
                count += 1;
            }
            if count > 2 {
                return false;
            }
        }
        true
    }
}