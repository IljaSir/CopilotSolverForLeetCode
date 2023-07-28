impl Solution {
    pub fn max_repeating(sequence: String, word: String) -> i32 {
        
        let mut k = 0;
        let mut seq = String::from(sequence);
        while seq.contains(&word) {
            k += 1;
            seq = seq.replace(&word, "");
        }
        k
    }
}