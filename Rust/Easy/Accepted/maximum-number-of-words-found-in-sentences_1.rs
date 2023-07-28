impl Solution {
    pub fn most_words_found(sentences: Vec<String>) -> i32 {
        
        let mut max = 0;
        for sentence in sentences {
            let words = sentence.split(' ').collect::<Vec<&str>>();
            if words.len() > max {
                max = words.len();
            }
        }
        max as i32
    }
}