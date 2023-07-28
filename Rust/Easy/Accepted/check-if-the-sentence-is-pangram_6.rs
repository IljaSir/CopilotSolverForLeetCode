impl Solution {
    pub fn check_if_pangram(sentence: String) -> bool {
        
        let mut chars = vec![false; 26];
        for c in sentence.chars() {
            let idx = c as u8 - 'a' as u8;
            chars[idx as usize] = true;
        }
        for c in chars {
            if c == false {
                return false;
            }
        }
        true
    }
}