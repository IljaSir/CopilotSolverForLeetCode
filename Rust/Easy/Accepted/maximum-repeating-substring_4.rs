impl Solution {
    pub fn max_repeating(sequence: String, word: String) -> i32 {
        
        let mut i = 1;
        let mut s = word.clone();
        while sequence.contains(&s) {
            i += 1;
            s = format!("{}{}", s, word);
        }
        i - 1
    }
}