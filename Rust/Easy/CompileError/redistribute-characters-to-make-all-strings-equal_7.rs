impl Solution {
    pub fn make_equal(words: Vec<String>) -> bool {
        
        let mut count = [0; 26];
        for word in words {
            for ch in word.chars() {
                count[(ch as u8 - b'a') as usize] += 1;
            }
        }
        for i in 0..26 {
            if count[i] % words.len() != 0 {
                return false;
            }
        }
        true
    }
}