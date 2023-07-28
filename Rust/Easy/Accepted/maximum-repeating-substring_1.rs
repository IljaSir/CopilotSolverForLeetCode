impl Solution {
    pub fn max_repeating(sequence: String, word: String) -> i32 {
        
        let mut res = 0;
        let mut s = word.clone();
        while sequence.contains(&s) {
            res += 1;
            s = format!("{}{}", s, word);
        }
        res
    }
}