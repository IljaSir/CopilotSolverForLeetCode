impl Solution {
    pub fn check_if_pangram(sentence: String) -> bool {
        
        let mut count = 0;
        let mut alphabet = [false; 26];
        for c in sentence.chars() {
            let index = c as usize - 'a' as usize;
            if !alphabet[index] {
                alphabet[index] = true;
                count += 1;
            }
        }
        count == 26
    }
}