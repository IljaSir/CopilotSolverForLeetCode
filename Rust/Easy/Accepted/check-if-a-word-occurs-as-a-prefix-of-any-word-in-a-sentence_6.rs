impl Solution {
    pub fn is_prefix_of_word(sentence: String, search_word: String) -> i32 {
        
        let mut index = 0;
        for word in sentence.split(' ') {
            index += 1;
            if word.starts_with(&search_word) {
                return index;
            }
        }
        -1
    }
}