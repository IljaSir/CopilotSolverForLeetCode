impl Solution {
    pub fn max_repeating(sequence: String, word: String) -> i32 {
        
        let mut n = 0;
        let mut s = String::from("");
        while s.len() <= sequence.len() {
            s += &word;
            if sequence.contains(&s) {
                n += 1;
            }
        }
        n
    }
}