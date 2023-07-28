impl Solution {
    pub fn is_sum_equal(first_word: String, second_word: String, target_word: String) -> bool {
        
        let mut first = 0;
        let mut second = 0;
        let mut target = 0;
        for c in first_word.chars() {
            first = first * 10 + c as i32 - 'a' as i32;
        }
        for c in second_word.chars() {
            second = second * 10 + c as i32 - 'a' as i32;
        }
        for c in target_word.chars() {
            target = target * 10 + c as i32 - 'a' as i32;
        }
        first + second == target
    }
}