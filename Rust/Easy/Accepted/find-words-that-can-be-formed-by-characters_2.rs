impl Solution {
    pub fn count_characters(words: Vec<String>, chars: String) -> i32 {
        
        let mut chars_count = vec![0; 26];
        for c in chars.chars() {
            chars_count[(c as u8 - b'a') as usize] += 1;
        }
        let mut result = 0;
        for word in words {
            let mut word_count = vec![0; 26];
            for c in word.chars() {
                word_count[(c as u8 - b'a') as usize] += 1;
            }
            if chars_count
                .iter()
                .zip(word_count.iter())
                .all(|(a, b)| *a >= *b)
            {
                result += word.len() as i32;
            }
        }
        result
    }
}