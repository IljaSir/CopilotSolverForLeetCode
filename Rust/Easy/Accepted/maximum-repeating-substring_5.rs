impl Solution {
    pub fn max_repeating(sequence: String, word: String) -> i32 {
        
        let mut res = 0;
        let mut tmp = String::from(&word);
        while sequence.contains(&tmp) {
            res += 1;
            tmp.push_str(&word);
        }
        res
    }
}