impl Solution {
    pub fn is_sum_equal(first_word: String, second_word: String, target_word: String) -> bool {
        
        fn word_to_num(word: String) -> i32 {
            word.chars().map(|c| (c as u8 - b'a') as i32).collect::<Vec<i32>>().join("").parse::<i32>().unwrap()
        }
        word_to_num(first_word) + word_to_num(second_word) == word_to_num(target_word)
    }
}