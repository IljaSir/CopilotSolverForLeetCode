impl Solution {
    pub fn is_sum_equal(first_word: String, second_word: String, target_word: String) -> bool {
        
        let mut first_word = first_word.chars().map(|c| (c as u8 - 'a' as u8) as i32).collect::<Vec<i32>>();
        let mut second_word = second_word.chars().map(|c| (c as u8 - 'a' as u8) as i32).collect::<Vec<i32>>();
        let mut target_word = target_word.chars().map(|c| (c as u8 - 'a' as u8) as i32).collect::<Vec<i32>>();
        let mut first_word_num = 0;
        let mut second_word_num = 0;
        let mut target_word_num = 0;
        for i in 0..first_word.len() {
            first_word_num += first_word[i] * 10_i32.pow((first_word.len() - i - 1) as u32);
            second_word_num += second_word[i] * 10_i32.pow((second_word.len() - i - 1) as u32);
            target_word_num += target_word[i] * 10_i32.pow((target_word.len() - i - 1) as u32);
        }
        first_word_num + second_word_num == target_word_num
    }
}