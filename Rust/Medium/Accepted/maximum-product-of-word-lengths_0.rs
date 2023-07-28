impl Solution {
    pub fn max_product(words: Vec<String>) -> i32 {
        

        let n = words.len();
        let mut masks = vec![0; n];
        let mut lens = vec![0; n];
        for (i, word) in words.iter().enumerate() {
            let mut mask = 0;
            for c in word.chars() {
                mask |= 1 << (c as u8 - b'a');
            }
            masks[i] = mask;
            lens[i] = word.len();
        }
        let mut ans = 0;
        for i in 0..n {
            for j in i + 1..n {
                if masks[i] & masks[j] == 0 {
                    ans = ans.max(lens[i] * lens[j]);
                }
            }
        }
        ans as i32
    }
}