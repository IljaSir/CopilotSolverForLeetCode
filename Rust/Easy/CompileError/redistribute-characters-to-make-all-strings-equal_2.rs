impl Solution {
    pub fn make_equal(words: Vec<String>) -> bool {
        
        let mut count = [0; 26];
        for word in words {
            for c in word.chars() {
                count[(c as u8 - 'a' as u8) as usize] += 1;
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