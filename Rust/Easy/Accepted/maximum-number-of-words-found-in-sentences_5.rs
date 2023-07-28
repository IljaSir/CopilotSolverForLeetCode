impl Solution {
    pub fn most_words_found(sentences: Vec<String>) -> i32 {
        
        let mut max_words = 0;
        for sentence in sentences.iter() {
            let words = sentence.split(" ").count();
            if words > max_words {
                max_words = words;
            }
        }
        max_words as i32
    }
}