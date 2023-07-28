impl Solution {
    pub fn check_if_pangram(sentence: String) -> bool {
        
        let mut arr = [false; 26];
        for c in sentence.chars() {
            arr[(c as u8 - 'a' as u8) as usize] = true;
        }
        for b in arr.iter() {
            if !*b {
                return false;
            }
        }
        true
    }
}