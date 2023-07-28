impl Solution {
    pub fn most_words_found(sentences: Vec<String>) -> i32 {
        
        let mut max = 0;
        for s in sentences {
            let mut count = 0;
            for _ in s.split_whitespace() {
                count += 1;
            }
            max = std::cmp::max(max, count);
        }
        max
    }
}