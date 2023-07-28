impl Solution {
    pub fn count_characters(words: Vec<String>, chars: String) -> i32 {
        
        let mut chars_count = vec![0; 26];
        for c in chars.chars() {
            chars_count[c as usize - 'a' as usize] += 1;
        }
        let mut result = 0;
        for word in words {
            let mut word_count = vec![0; 26];
            for c in word.chars() {
                word_count[c as usize - 'a' as usize] += 1;
            }
            let mut good = true;
            for i in 0..26 {
                if word_count[i] > chars_count[i] {
                    good = false;
                    break;
                }
            }
            if good {
                result += word.len() as i32;
            }
        }
        result
    }
}