impl Solution {
    pub fn max_repeating(sequence: String, word: String) -> i32 {
        
        let mut s = word;
        for i in 1..=sequence.len() / word.len() {
            if !sequence.contains(&s) {
                return (i - 1) as i32;
            }
            s += &word;
        }
        sequence.len() as i32 / word.len() as i32
    }
}