impl Solution {
    pub fn max_product(words: Vec<String>) -> i32 {
        

        let mut word_nums = vec![0i32; words.len()];
        for (i, word) in words.iter().enumerate() {
            for c in word.chars() {
                word_nums[i] |= 1 << (c as u8 - b'a');
            }
        }
        let mut max = 0;
        for i in 0..words.len() {
            for j in i+1..words.len() {
                if word_nums[i] & word_nums[j] == 0 {
                    max = max.max(words[i].len() * words[j].len());
                }
            }
        }
        max as i32
    }
}