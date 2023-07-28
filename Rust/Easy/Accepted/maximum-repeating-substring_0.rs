impl Solution {
    pub fn max_repeating(sequence: String, word: String) -> i32 {
        
        let mut ans = 0;
        let mut s = word.clone();
        while sequence.contains(&s) {
            ans += 1;
            s += &word;
        }
        ans
    }
}