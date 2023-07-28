impl Solution {
    pub fn max_product(words: Vec<String>) -> i32 {
        

        let n = words.len();
        let mut masks = vec![0; n];
        let mut lens = vec![0; n];
        for (i, word) in words.iter().enumerate() {
            for ch in word.chars() {
                masks[i] |= 1 << (ch as u8 - b'a');
            }
            lens[i] = word.len();
        }
        let mut ret = 0;
        for i in 0..n {
            for j in i + 1..n {
                if masks[i] & masks[j] == 0 {
                    ret = ret.max(lens[i] * lens[j]);
                }
            }
        }
        ret as i32
    }
}