impl Solution {
    pub fn count_characters(words: Vec<String>, chars: String) -> i32 {
        
        let mut char_count = vec![0; 26];
        for c in chars.chars() {
            char_count[c as usize - 'a' as usize] += 1;
        }
        let mut res = 0;
        for word in words {
            let mut word_count = vec![0; 26];
            for c in word.chars() {
                word_count[c as usize - 'a' as usize] += 1;
            }
            let mut can_form = true;
            for i in 0..26 {
                if word_count[i] > char_count[i] {
                    can_form = false;
                    break;
                }
            }
            if can_form {
                res += word.len() as i32;
            }
        }
        res
    }
}