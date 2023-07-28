impl Solution {
    pub fn count_valid_words(sentence: String) -> i32 {
        
        let mut count = 0;
        let mut is_valid = true;
        let mut has_hyphen = false;
        let mut has_punctuation = false;
        for ch in sentence.chars() {
            if ch == ' ' {
                count += is_valid as i32;
                is_valid = true;
                has_hyphen = false;
                has_punctuation = false;
            } else if ch == '-' {
                if has_hyphen || !is_valid {
                    is_valid = false;
                }
                has_hyphen = true;
            } else if ch == '.' || ch == '!' || ch == ',' {
                if has_punctuation || !is_valid {
                    is_valid = false;
                }
                has_punctuation = true;
            } else if !ch.is_ascii_lowercase() {
                is_valid = false;
            }
        }
        count += is_valid as i32;
        count
    }
}