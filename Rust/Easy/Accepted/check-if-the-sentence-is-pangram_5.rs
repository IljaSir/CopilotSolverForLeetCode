impl Solution {
    pub fn check_if_pangram(sentence: String) -> bool {
        
        let mut arr = vec![0; 26];
        for c in sentence.chars() {
            arr[(c as u8 - b'a') as usize] += 1;
        }
        for i in 0..26 {
            if arr[i] == 0 {
                return false;
            }
        }
        true
    }
}