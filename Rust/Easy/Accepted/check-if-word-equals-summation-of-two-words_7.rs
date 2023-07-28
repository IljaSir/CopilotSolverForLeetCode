impl Solution {
    pub fn is_sum_equal(first_word: String, second_word: String, target_word: String) -> bool {
        
        let mut first_word = first_word;
        let mut second_word = second_word;
        let mut target_word = target_word;
        let mut first = 0;
        let mut second = 0;
        let mut target = 0;
        for c in first_word.chars() {
            first = first * 10 + (c as u8 - 'a' as u8) as i32;
        }
        for c in second_word.chars() {
            second = second * 10 + (c as u8 - 'a' as u8) as i32;
        }
        for c in target_word.chars() {
            target = target * 10 + (c as u8 - 'a' as u8) as i32;
        }
        first + second == target
    }
}