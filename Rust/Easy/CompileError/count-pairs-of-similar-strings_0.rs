impl Solution {
    pub fn similar_pairs(words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for i in 0..words.len() {
            for j in i+1..words.len() {
                if Solution::is_similar(&words[i], &words[j]) {
                    count += 1;
                }
            }
        }
        count
    }
}