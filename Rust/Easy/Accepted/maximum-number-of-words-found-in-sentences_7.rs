impl Solution {
    pub fn most_words_found(sentences: Vec<String>) -> i32 {
        
        sentences.into_iter().map(|s| s.split(' ').count() as i32).max().unwrap()
    }
}