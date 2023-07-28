impl Solution {
    pub fn is_sum_equal(first_word: String, second_word: String, target_word: String) -> bool {
        
        let mut first_word = first_word.chars().map(|c| (c as u8 - 'a' as u8) as i32).collect::<Vec<i32>>();
        let mut second_word = second_word.chars().map(|c| (c as u8 - 'a' as u8) as i32).collect::<Vec<i32>>();
        let mut target_word = target_word.chars().map(|c| (c as u8 - 'a' as u8) as i32).collect::<Vec<i32>>();
        let mut first_word = first_word.iter().fold(0, |acc, x| acc * 10 + x);
        let mut second_word = second_word.iter().fold(0, |acc, x| acc * 10 + x);
        let mut target_word = target_word.iter().fold(0, |acc, x| acc * 10 + x);
        first_word + second_word == target_word
    }
}