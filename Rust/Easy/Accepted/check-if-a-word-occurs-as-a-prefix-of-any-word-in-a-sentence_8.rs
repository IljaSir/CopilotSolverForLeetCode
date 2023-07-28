impl Solution {
    pub fn is_prefix_of_word(sentence: String, search_word: String) -> i32 {
        
        let mut i = 0;
        for w in sentence.split_whitespace() {
            i += 1;
            if w.starts_with(&search_word) {
                return i as i32;
            }
        }
        -1
    }
}