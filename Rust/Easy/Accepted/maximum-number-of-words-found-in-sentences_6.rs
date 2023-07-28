impl Solution {
    pub fn most_words_found(sentences: Vec<String>) -> i32 {
        
        let mut max = 0;
        for sentence in sentences {
            let words = sentence.split(" ");
            let mut count = 0;
            for _ in words {
                count += 1;
            }
            if count > max {
                max = count;
            }
        }
        return max as i32;
    }
}