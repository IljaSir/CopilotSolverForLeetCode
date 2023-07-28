impl Solution {
    pub fn is_sum_equal(first_word: String, second_word: String, target_word: String) -> bool {
        
        let mut f = 0;
        let mut s = 0;
        let mut t = 0;
        for c in first_word.chars() {
            f *= 10;
            f += (c as u8 - 'a' as u8) as i32;
        }
        for c in second_word.chars() {
            s *= 10;
            s += (c as u8 - 'a' as u8) as i32;
        }
        for c in target_word.chars() {
            t *= 10;
            t += (c as u8 - 'a' as u8) as i32;
        }
        f + s == t
    }
}