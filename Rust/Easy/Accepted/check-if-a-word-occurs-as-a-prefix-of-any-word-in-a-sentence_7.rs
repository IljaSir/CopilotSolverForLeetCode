impl Solution {
    pub fn is_prefix_of_word(sentence: String, search_word: String) -> i32 {
        
        let words: Vec<&str> = sentence.split(' ').collect();
        let mut i = 1;
        for word in words {
            if word.starts_with(&search_word) {
                return i;
            }
            i += 1;
        }
        -1
    }
}