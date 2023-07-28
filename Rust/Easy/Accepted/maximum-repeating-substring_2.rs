impl Solution {
    pub fn max_repeating(sequence: String, word: String) -> i32 {
        
        let mut count = 0;
        let mut new_word = word.clone();
        while sequence.contains(&new_word) {
            count += 1;
            new_word.push_str(&word);
        }
        count
    }
}