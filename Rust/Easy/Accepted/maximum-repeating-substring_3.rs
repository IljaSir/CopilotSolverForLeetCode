impl Solution {
    pub fn max_repeating(sequence: String, word: String) -> i32 {
        
        let mut n = 0;
        let mut s = word.clone();
        while sequence.contains(&s) {
            n += 1;
            s += &word;
        }
        n
    }
}