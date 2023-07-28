impl Solution {
    pub fn count_valid_words(sentence: String) -> i32 {
        
        let mut valid = 0;
        let mut hyphen = false;
        let mut punctuation = false;
        for c in sentence.chars() {
            if c.is_ascii_lowercase() {
                hyphen = false;
                punctuation = false;
            } else if c == '-' {
                if hyphen || punctuation {
                    valid -= 1;
                    break;
                }
                hyphen = true;
            } else if c == '.' || c == ',' || c == '!' {
                if punctuation || hyphen {
                    valid -= 1;
                    break;
                }
                punctuation = true;
            } else if c == ' ' {
                if hyphen || punctuation {
                    valid -= 1;
                    break;
                }
                valid += 1;
            } else {
                valid -= 1;
                break;
            }
        }
        if valid < 0 {
            0
        } else {
            valid + 1
        }
    }
}