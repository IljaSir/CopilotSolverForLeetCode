impl Solution {
    pub fn most_words_found(sentences: Vec<String>) -> i32 {
        
        let mut max = 0;
        for s in sentences {
            let mut count = 0;
            for c in s.chars() {
                if c == ' ' {
                    count += 1;
                }
            }
            if count > max {
                max = count;
            }
        }
        max + 1
    }
}