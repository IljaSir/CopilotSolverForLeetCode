impl Solution {
    pub fn is_prefix_of_word(sentence: String, search_word: String) -> i32 {
        
        let mut count = 1;
        for word in sentence.split_whitespace() {
            if word.starts_with(&search_word) {
                return count;
            }
            count += 1;
        }
        -1
    }
}