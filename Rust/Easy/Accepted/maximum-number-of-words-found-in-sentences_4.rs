impl Solution {
    pub fn most_words_found(sentences: Vec<String>) -> i32 {
        
        let mut max = 0;
        for sentence in sentences {
            let word_count = sentence.split(" ").count();
            if word_count > max {
                max = word_count;
            }
        }
        max as i32
    }
}