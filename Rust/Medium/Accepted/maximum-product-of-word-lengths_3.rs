impl Solution {
    pub fn max_product(words: Vec<String>) -> i32 {
        

        let mut masks = vec![0; words.len()];
        for (i, word) in words.iter().enumerate() {
            for c in word.chars() {
                masks[i] |= 1 << (c as usize - 97);
            }
        }
        let mut max = 0;
        for i in 0..masks.len() {
            for j in i + 1..masks.len() {
                if masks[i] & masks[j] == 0 {
                    max = max.max(words[i].len() * words[j].len());
                }
            }
        }
        max as i32
    }
}