impl Solution {
    pub fn check_if_pangram(sentence: String) -> bool {
        
        let mut chars = [false; 26];
        for c in sentence.chars() {
            chars[(c as u8 - b'a') as usize] = true;
        }
        for i in 0..26 {
            if chars[i] == false {
                return false;
            }
        }
        true
    }
}