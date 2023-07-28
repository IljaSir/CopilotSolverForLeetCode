impl Solution {
    pub fn count_valid_words(sentence: String) -> i32 {
        
        let mut count = 0;
        let mut is_valid = true;
        let mut has_hyphen = false;
        let mut has_punctuation = false;
        for c in sentence.chars() {
            if c == ' ' {
                if is_valid {
                    count += 1;
                }
                is_valid = true;
                has_hyphen = false;
                has_punctuation = false;
            } else if c == '-' {
                if has_hyphen || !is_valid {
                    is_valid = false;
                }
                has_hyphen = true;
            } else if c == '!' || c == '.' || c == ',' {
                if has_punctuation || !is_valid {
                    is_valid = false;
                }
                has_punctuation = true;
            } else if c.is_digit(10) {
                is_valid = false;
            }
        }
        if is_valid {
            count += 1;
        }
        count
    }
}