impl Solution {
    pub fn is_prefix_of_word(sentence: String, search_word: String) -> i32 {
        
        let mut index = 1;
        for word in sentence.split(' ') {
            if word.starts_with(&search_word) {
                return index;
            }
            index += 1;
        }
        -1
    }
}