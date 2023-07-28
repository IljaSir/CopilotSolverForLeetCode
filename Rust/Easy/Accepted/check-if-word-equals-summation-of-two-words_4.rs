impl Solution {
    pub fn is_sum_equal(first_word: String, second_word: String, target_word: String) -> bool {
        
        let mut f = 0;
        for c in first_word.chars() {
            f = f * 10 + (c as usize - 'a' as usize);
        }
        let mut s = 0;
        for c in second_word.chars() {
            s = s * 10 + (c as usize - 'a' as usize);
        }
        let mut t = 0;
        for c in target_word.chars() {
            t = t * 10 + (c as usize - 'a' as usize);
        }
        f + s == t
    }
}