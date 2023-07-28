impl Solution {
    pub fn max_product(words: Vec<String>) -> i32 {
        

        let mut mask = vec![0; words.len()];
        let mut max = 0;
        for (i, word) in words.iter().enumerate() {
            for c in word.chars() {
                mask[i] |= 1 << (c as u8 - b'a' as u8);
            }
            for j in 0..i {
                if mask[i] & mask[j] == 0 {
                    max = max.max(words[i].len() * words[j].len());
                }
            }
        }
        max as i32
    }
}