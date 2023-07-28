impl Solution {
    pub fn most_words_found(sentences: Vec<String>) -> i32 {
        
        let mut max = 0;
        for sentence in sentences {
            let words = sentence.split(" ").count();
            if words > max {
                max = words;
            }
        }
        max as i32
    }
}