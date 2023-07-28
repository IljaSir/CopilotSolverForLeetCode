impl Solution {
    pub fn is_sum_equal(first_word: String, second_word: String, target_word: String) -> bool {
        
        let mut first_word = first_word;
        let mut second_word = second_word;
        let mut target_word = target_word;
        let mut first_num = String::new();
        let mut second_num = String::new();
        let mut target_num = String::new();
        for c in first_word.chars() {
            first_num.push((c as u8 - 97) as char);
        }
        for c in second_word.chars() {
            second_num.push((c as u8 - 97) as char);
        }
        for c in target_word.chars() {
            target_num.push((c as u8 - 97) as char);
        }
        let first_num: i32 = first_num.parse().unwrap();
        let second_num: i32 = second_num.parse().unwrap();
        let target_num: i32 = target_num.parse().unwrap();
        first_num + second_num == target_num
    }
}