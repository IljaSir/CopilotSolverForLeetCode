impl Solution {
    pub fn is_sum_equal(first_word: String, second_word: String, target_word: String) -> bool {
        
        let mut first = 0;
        let mut second = 0;
        let mut target = 0;
        for c in first_word.chars() {
            first *= 10;
            first += (c as u8 - 97) as i32;
        }
        for c in second_word.chars() {
            second *= 10;
            second += (c as u8 - 97) as i32;
        }
        for c in target_word.chars() {
            target *= 10;
            target += (c as u8 - 97) as i32;
        }
        first + second == target
    }
}