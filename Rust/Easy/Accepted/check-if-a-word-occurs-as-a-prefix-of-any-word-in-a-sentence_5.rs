impl Solution {
    pub fn is_prefix_of_word(sentence: String, search_word: String) -> i32 {
        
        let mut i = 1;
        for w in sentence.split(' ') {
            if w.starts_with(&search_word) {
                return i;
            }
            i += 1;
        }
        -1
    }
}