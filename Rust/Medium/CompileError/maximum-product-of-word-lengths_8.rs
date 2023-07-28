impl Solution {
    pub fn max_product(words: Vec<String>) -> i32 {
        

        let mut max = 0;
        let mut bit_words = vec![];
        for w in words {
            let mut bit_word = 0;
            for c in w.chars() {
                bit_word |= 1 << (c as u8 - 'a' as u8);
            }
            bit_words.push(bit_word);
        }
        for i in 0..bit_words.len() {
            for j in i+1..bit_words.len() {
                if bit_words[i] & bit_words[j] == 0 {
                    let product = words[i].len() * words[j].len();
                    if product > max {
                        max = product;
                    }
                }
            }
        }
        max as i32
    }
}